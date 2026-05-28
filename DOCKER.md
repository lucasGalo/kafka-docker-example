# Docker imagem pronta no dockerHub

## Criando uma imagen e push para dockerhub a partir do projeto.

1. **Deletar imagens antigas**
    ```bash
        docker rmi kafka-docker-example:0.1.0
    ``` 
2. **Build do projeto**
    ```bash
   docker build -t kafka-docker-example:0.1.0 -f docker/Dockerfile .   
   ``` 
3. **Tag do build**
   ```bash
        docker tag 42ac810c8c36 lucasgalo/kafka-docker-example:0.1.0
   ```
4. **Login dockerhub**
   ```bash
        docker login
   ```
5. **Push da tag**
    ```bash
        docker push lucasgalo/kafka-docker-example:0.1.0
    ```

## Container create example:

1. **Create work directories:**
    ```bash
    mkdir -p /home/kafka-docker-example/logs    
    ```
2. **Permissao de leitura e escrita para a pasta**
   ```bash
     sudo chmod 777 -R /home/kafka-docker-example/logs
   ```
3. **Create container:**
    ```bash
    docker run \
    --name kafka-docker-example \
    --hostname ambienteclean \
    --detach --restart unless-stopped \
    --publish 56895:56895 \
    --volume /home/kafka-docker-example/logs:/opt/ambienteclean/logs:rw \
    --volume /home/kafka-docker-example/application-prod.properties:/opt/ambienteclean/src/resources/application-prod.properties:ro \
    lucasgalo/kafka-docker-example:0.1.0
    ```   
4. **Create container, servidor externo**
    ```bash
     docker run --name kafka-docker-example --network="host" --detach --restart unless-stopped --publish 56895:56895 --volume /home/kafka-docker-example/logs:/opt/ambienteclean/logs:rw --volume /home/kafka-docker-example/application-prod.properties:/opt/ambienteclean/src/resources/application-prod.properties:ro lucasgalo/kafka-docker-example:0.1.0
    ```
5. **Other option create container local:**
    ```bash
    docker run --name clean --network="host" --detach --restart unless-stopped --publish 56895:56895 clean:0.1.0
    ```
6. **See in logs the container creates:**
    ```bash
    docker container logs 7b2   
    ```
7. **See all redes:**
    ```bash
    docker network ls
    ```
