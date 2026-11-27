package com.example.projetjava.simulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DeviceSimulator implements CommandLineRunner {
 private final DeviceEventService eventService;
 public DeviceSimulator(DeviceEventService eventService) {
 this.eventService = eventService;
 }
 @Override
 public void run(String... args) {
 // Envoyer plusieurs DeviceMessage fictifs :
 // mouvement, intrusion, température normale,
 // variation importante, température anormale.
 // Chaque message passe par eventService.process(...).
 }
}