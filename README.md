1_REQUISITOS PARA EL FUNCIONAMIENTO 
SERVICIO USUARIO
•	docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Password_Fuerte_123!" -p 1433:1433 --name sqlserver -d mcr.microsoft.com/mssql/server:2022-latest
•	docker exec -it sqlserver /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P "Password_Fuerte_123!" -Q "CREATE DATABASE UsuariosDb"
•	EJECUTAR EL CONTENEDOR

Al ejecutar estos dos comandos en la terminal de doker tendremos la imagen y el contenedor asi como la base de datos 
SERVICIO PEDIDOS Y PRODUCTOS
•	Ejecutar en xamp el apache y mysql prioridad puerto 3306
•	En caso de no funcionar es porque lo ocupa workbench u otra app se puede detener el servicio temporalmente para el correcto funcionamiento 
•	Asegurse tener mysql 3306 corriendo 


3_EVIDENCIAS DE FUNCIONAMIENTO POSTMAN 
REQUISITOS RUTAS: 
Asegurarnos de tener un usuario creado
http://localhost:8080/USERS-SERVICE/usuarios      para post     
http://localhost:8080/USERS-SERVICE/usuarios/1     para get con id    


{
    "nombre": "Melisa",
    "email": "andre@gmail.com",
    "password": "123"
}

Asegurarnos de tener productos creados 

http://localhost:8080/ PRODUCTS-SERVICE/productos      para post     
http://localhost:8080/PRODUCTS-SERVICE/productos/1     para get con id    

{
    "nombre": "Queso",
    "descripcion": "Parmesano",
    "precio": 45.99,
    "stock": 20
}

Asegurarnos de usar id de producto existente y también id de usuario existente  

http://localhost:8080/ORDERS-SERVICE/pedidos  para post o para get    
{
  "usuarioId": "1",
  "nombreCliente": "Goku Son",
  "emailCliente": "goku@dbz.com",
  "direccionEnvio": "Montaña Paoz, Distrito 439",
  "productos": [
    {
      "productoId": 1,
      "nombreProducto": "Semillas del Ermitaño",
      "cantidad": 5,
      "precioUnitario": 100.00
    },
    {
      "productoId": 1,
      "nombreProducto": "Nube Voladora",
      "cantidad": 1,
      "precioUnitario": 500.50
    }
  ]
}
