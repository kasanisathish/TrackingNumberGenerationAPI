# Tracking Number API

A scalable, RESTful API that generates unique tracking numbers for parcels.

## Features

- Endpoint: `GET /next-tracking-number`
- Accepts query parameters (country codes, weight, timestamp, customer details)
- Returns a unique tracking number
- Concurrency-safe and scalable

## Run Locally

```bash
./mvnw spring-boot:run
```

## Docker

```bash
docker build -t tracking-number-api .
docker run -p 8080:8080 tracking-number-api
```

## Sample Request

```http
GET /next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2023-01-01T10:00:00+08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics
```
