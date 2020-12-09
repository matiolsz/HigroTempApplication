package pl.olszanka.HigroTempApplication.scheduled;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.olszanka.HigroTempApplication.domain.Measurement;
import pl.olszanka.HigroTempApplication.service.MeasurementService;

@Component
public class ScheduledTasks {

    MeasurementService measurementService;

    @Autowired
    private ScheduledTasks(MeasurementService measurementService){
        this.measurementService=measurementService;
    }

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
       // log.info("The time is now {} ", dateFormat.format(new Date()));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.1.138/measurement"))
                .build();
        HttpResponse response;

        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                measurementService.create(new Measurement(Double.valueOf(String.valueOf(response.body()))));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}