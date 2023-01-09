# FORMACIÓN MDM

En este proyecto se pretende simular el comportamiento de una 
aplicación MDM a nivel básico con SpringBoot. La aplicación desarrollada
simula el alta de los siguientes registros: 

## Diagrama

![image](https://user-images.githubusercontent.com/101171440/211258357-59d7b74f-d1ba-4c83-9255-1f968a23f1f6.png)

## Instalación

Clonar repositorio, instalar dependencias y lanzar aplicación. Con estos
pasos podremos realizar peticiones en Postman u otro tipo de aplicación.

## Funcionamiento interno

Una vez recibida una petición de alta o modificación, realizamos una previa
validación de los datos de entrada, en caso de ser correctos, procedemos con 
los siguientes pasos:

- Si recibios como parámetro el id de la entidad, asumimos que se intenta
realizar una modifiación con los demás campos propuestos. Si por el contrario
no se notifica el id, se realizará un alta.
- Una vez procesados los datos, haremos una llamada al cliente SIF para
...
