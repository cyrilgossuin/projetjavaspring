package com.example.projetjava.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projetjava.domain.Device;
import com.example.projetjava.domain.DeviceEvent;
//import com.example.projetjava.http.DeviceMessage;
import com.example.projetjava.observer.ObserverManager;
import com.example.projetjava.repository.DeviceEventRepository;
import com.example.projetjava.repository.DeviceRepository;

@Service
public class DeviceEventService {
    private final DeviceRepository devices;
    private final DeviceEventRepository events;
    private final ObserverManager observerManager;

    public DeviceEventService(DeviceRepository devices,
                              DeviceEventRepository events,
                              ObserverManager observerManager) {
        this.devices = devices;
        this.events = events;
        this.observerManager = observerManager;
    }

    @Transactional
    public void process(DeviceMessage msg) {
        Device device = devices.findById(msg.deviceId())
            .orElseThrow(() -> new IllegalArgumentException(
                "Appareil inconnu"));

        // 1. Vérifier que l'appareil est actif.
        // 2. Comparer la mesure aux valeurs précédentes/seuils.
        // 3. Mettre à jour la mesure courante.
        // 4. Construire et enregistrer le DeviceEvent.
        DeviceEvent event = /* création de l'événement */;
        events.save(event);

        // Notifier après validation et création de l'événement.
        observerManager.notifyAll(event);
    }
}
