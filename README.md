# TpSistemaDeGestionOrdenesDC

### *Este sistema de Ordenes de Compra Consta solo del backend, dentro del cual se desarrollaron ademas de las ABMs de Productos, Clientes, Vendedores y Promociones, el proceso de compra de un producto por parte de un cliente. Los métodos donde se quiere cargar, por ejemplo, un producto o una promocion, se debe realizar mediante el Postman, mientras que las consultas de tipo Get, ya sea para buscar un objeto en especifico o una lista paginada de los mismos, se pueden acceder mediante la url.*
### *Los datos iniciales se cargan en el InitData cuando arranca el programa, entre los cuales se encuentran:*

#### *Cliente(Posee una tarjeta como medio de pago, un carrito de compras asociado vacio y cupones, ademas de ser miembro)*

#### *Vendedor(No posee productos cargados ni ordenes de compra, mas sí promociones(una de miembros y otra de medioDePago))*
### *El proyecto se subió a heroku, al cual se puede acceder mediante la siguiente url:*

### *ACLARACIONES:* 

#### *Tanto cliente como vendedor, al ser clases heredadas de Usuario, comparten los atributos de mail, password y dni*

#### *Existen 3 tipos de promociones: Por medio de pago, por membresia y por cupones asociados a un producto*

#### *El cliente no posee una lista de cupones en si como atributo, si no mas bien una lista de numero relacionados a un cupon*

#### *Las ordenes de compra se generan automaticamente despues de que el cliente efectua una compra*

#### *Las promociones se aplican en el momento de la compra*

#### *Tanto el metodo para agregar un producto al carrito como el metodo para pagar por los productos dentro del mismo se encuentran dentro del ClienteControllerComplemet*

### *EJEMPLOS APLICABLES:*

#### *Subir un producto: birome(nombre = "birome", stock = 500, proveedor = "Carlos", vendedor = cacho, precio = 130)*
#### *Subir un producto: lapiz(nombre = "lapiz", stock = 600, proveedor = "Luis", vendedor = cacho, precio = 100)*

#### *Subir un cupon: descBirome(fechaLimite = 04112022, producto = birome, numero = 5678, monto = 75)*

#### *Subir una promoCupon: promoBirome(nombre = "promoBirome", cupon = descBirome)*

#### *Agregar un producto al carrito: cliente = mauro, producto = birome, cantidad = 5*
#### *Agregar un producto al carrito: cliente = mauro, producto = lapiz, cantidad = 3*

#### *Pagar: cliente = mauro*
