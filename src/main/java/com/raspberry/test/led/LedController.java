package com.raspberry.test.led;

import com.pi4j.io.gpio.*;
import com.raspberry.test.common.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class LedController {

    public static GpioPinDigitalOutput pin;

    @RequestMapping("/led/health")
    public String checkHealth(){
        return "LED is alive";
    }

    @RequestMapping("/led/turnon")
    public String turnOnTheLed(){
        GpioController gpioController = GpioFactory.getInstance();
        pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "led 1", PinState.LOW);
        pin.high();

        return "led is turned on";
    }

    @RequestMapping("/led/turnoff")
    public String turnOffTheLed(){
        GpioController gpioController = GpioFactory.getInstance();
        pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "led 1", PinState.LOW);
        pin.low();

        return "led is turned off";
    }
}
