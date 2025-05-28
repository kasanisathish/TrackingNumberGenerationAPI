package com.example.tracking.service;

import com.example.tracking.model.TrackingResponse;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.UUID;

@Service
public class TrackingService {

    public TrackingResponse generateTrackingNumber(String origin, String destination, double weight,
                                                   OffsetDateTime createdAt, UUID customerId,
                                                   String customerName, String customerSlug) {
        try {
            String input = origin + destination + weight + createdAt.toString() +
                           customerId + customerName + customerSlug + System.nanoTime();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            String base36 = new java.math.BigInteger(1, hash).toString(36).toUpperCase();

            String trackingNumber = base36.replaceAll("[^A-Z0-9]", "").substring(0, Math.min(16, base36.length()));

            return new TrackingResponse(trackingNumber, OffsetDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate tracking number", e);
        }
    }
}
