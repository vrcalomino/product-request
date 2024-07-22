# Product Requests Sender

This is one of the services of this [project](https://github.com/vrcalomino/product-queue).

This one consists of an API that receives product requests and sends them to a rabbitmq queue.

## Run the project!

I'd recommend running the whole project following the instructions of the main Readme.
However, you can run this service alone.

First you need to create an .env file with these credentials:

```.dotenv
RABBITMQ_HOST=localhost
RABBITMQ_PORT=5672
RABBITMQ_USERNAME=guest
RABBITMQ_PASSWORD=guest
```

### Local:

I'll leave you steps to run the project manually:

- Run `mvn clean package`
- Then run `java -jar target/product-0.0.1-SNAPSHOT.jar`

### With docker:

- Run `docker build -t <image_name> .`
- Then run `docker run <image_name>`

### Try the project!

## Try the project!

The service only has one endpoint, to test it with curl:
```bash
curl -X POST http://localhost:8080/product/request -H "Content-Type: application/json" -d '{"email":"your_email", 
"product_id": product_id}'
```
If you want to test it with powershell run:
```powershell
$url = "http://localhost:8080/product/request"
$headers = @{
    "Content-Type" = "application/json"
}
$body = @{
    "email" = "email@email.com"
    "product_id" = product_id
}
$jsonBody = $body | ConvertTo-Json
$response = Invoke-WebRequest -Uri $url -Method POST -Headers $headers -Body $jsonBody -ErrorAction Stop
Write-Output $response.Content
```
Note: If you aren't running the other service as well as a rabbitmq server, this will do nothing.

#### Technologies:

- Maven
- Java 17