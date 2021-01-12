package pl.olszanka.HigroTempApplication.scheduled;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import pl.olszanka.HigroTempApplication.domain.Measurement;
import pl.olszanka.HigroTempApplication.domain.Sensor;
import pl.olszanka.HigroTempApplication.domain.dto.MeasurementResponse;
import pl.olszanka.HigroTempApplication.service.MeasurementService;
import pl.olszanka.HigroTempApplication.service.SensorService;

import java.text.SimpleDateFormat;

@Component
public class ScheduledTasks {

    MeasurementService measurementService;
    SensorService sensorService;
    Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    private ScheduledTasks(MeasurementService measurementService, SensorService sensorService) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    public MeasurementResponse callGet(String url) throws ResourceAccessException, HttpMessageNotReadableException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://" + url + "/measurement",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                MeasurementResponse.class).getBody();
    }


    @Scheduled(cron = "${measurement.cron:*/1 * * * * *}")
    public void reportCurrentTime() {
        logger.info("banana!!!");
        for (Sensor sensor : sensorService.findAll()) {
            try {
                MeasurementResponse measurementResponse = callGet(sensor.getIP());
                measurementService.create(new Measurement(measurementResponse.getValue(), System.currentTimeMillis(), sensor));
                logger.info("Dodano nowy pomiar");
            } catch (ResourceAccessException e) {
                logger.error("czujnik zwraca nieodczytywalną odpowiedź");
            } catch (HttpMessageNotReadableException e) {
                logger.error("Brak połączenia z czujnikiem");
            }
        }
    }
}