# Ejecución del proyecto

## Endpoints

Los siguientes endpoints están expuestos:

## GET /hello

Imprime un hola mundo

## POST /archivo

Para cargar un archivo, el cuerpo se manda como un objeto JSON como el siguiente:

```js
{
    "contentLength":0,
    "mimeType":"application/x-yaml",
    "fileName":"app1.yaml",
    "content":"cnVudGltZTogamF2YTExCmluc3RhbmNlX2NsYXNzOiBGMgoKc2VydmljZTogamF2YS1ub3RpZmljYXRpb24",
    "idCliente":"12312132",
    "processId":"123456",
    "tipoDocumento":"IFE"
}
```

Y devuelve una respuesta como la siguiente

```js
{
"documentID": null,
"exito": true,
"mensajeError": null
}
```

## Parámetros de configuración

Solo se requiere configurar la URL al WSDL del servicio de carga del BPM en el archivo **application.properties**

```properties
bpm.documentows.url=https://localhost:9444/teamworks/webservices/VD/documentoWS.tws?WSDL
```

## GET /swagger

Devuelve la especificación swagger del proyecto

## GET /swagger-ui

Devuelve la documentación swagger del proyecto

## Notas importantes para el modo desarrollo

Dado que el entorno BPM de desarrollo utiliza un certificado autofirmado que además no cuenta con un dominio válido 
"localhost", se implementó un "Trust Manager" que permite aceptar peticiones con un certificado no válido, 
para habilitarlo hay que configurar en el archivo **application.properties** la siguiente propiedad: 

```properties
bpm.useblindtrustmanager=true
```

Y de manera adicional hay que agregar el trust store que se encuentra en el proyecto como parámetro para la JVM:

```shell script
-Djavax.net.ssl.trustStore=src/main/resources/cacerts 
-Djavax.net.ssl.trustStorePassword=changeit
```

**Esto no es necesario en ningún otro ambiente**

## Ejecución en modo desarrollo

Con la siguiente instrucción se puede levantar el microservicio con el trust store que acepta conexiones a nuestro 
ambiente de desarrollo: 

```shell script
./mvnw clean compile quarkus:dev -Djavax.net.ssl.trustStore=src/main/resources/cacerts \
-Djavax.net.ssl.trustStorePassword=changeit
```

## Proyecto Postman

Ubicado en el archivo **Banorte Seguros.postman_collection.json**


