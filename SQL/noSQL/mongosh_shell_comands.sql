/**
  * TEMARIO
  *
  * - BD        (equivalente: crear BD ó ESQUEMA)
  * - COLECCION (equivalente: crear TABLA)
  * - DOCUMENTO (equivalente: un objeto JSON)
  * - _id       (id por defecto para cualquier DOCUMENTO de mongo)
  */


  --mostrar
show <comando-a-visualizar>
  --mostrar base datos
show bds
  --mostrar Colecciones de un Documento
show collections


  --crear DOCUMENTO  ó  swicharse a DOCUMENTO existente
use <nombre-bd>
  --crear una COLECCION (equivalente: crear una TABLA)
db.createCollection("mi_coleccion")
db.createCollection("usuarios")


/*
  [UTILIDADES]
*/
--SHIFT+ENTER   :crear nuevo salto de linea sobre el comando escrito
db.<coleccion-nombre>.insertOne({ /*SHIFT+ENTER*/ })


/*
        ***CRUD***
*/

  -- [CREATE]: insertar documentos - agregar nuevo documento a una coleccion
db.<coleccion-nombre>.insertOne({ JSON })

db.usuarios.insertOne({
  nombre:"Juan Pérez",
  edad:30,
  ciudad:"Ejemploville"
})


-- [READ]: buscar documentos - consultar documentos en una coleccion
-- obtener todos los documentos, obtener todos los usuarios
db.<coleccion-nombre>.find()
db.usuarios.find()
--Encontrar todos los usuarios mayores de 25 añós
db.<coleccion-nombre>.find({ JSON })
db.usuarios.find({ edad: {$gt:25} })


-- [UPDATE]: modificar documentos en una coleccion
db.usuarios.updateOne(
  { JSON.FILTRO.CONDICIONAL },
  { JSON.CAMBIO }
)
--Actualizar la edad del usuario "Juan Pérez" a 35 años
db.usuarios.updateOne(
  { nombre:"Juan Pérez" },
  { $set: {edad:36} }
)


-- [DELETE]: eliminar documentos en una coleccion
--Eliminar el usuario "Juan Pérez"
db.usuarios.deleteOne({ nombre:"Juan Pérez" })


/*
        ***OPERADORES RELACIONES - CONDICIONALES***
*/

  -- [Operadores relacionales]  $eq, $gt, $gte, $lt, $lte, $in, $nin y $ne
https://www.tutorialesprogramacionya.com/mongodbya/detalleconcepto.php?punto=9&codigo=9&inicio=0


--__________________________________________________________________________
--___________________________________________________________________________


/**
  * ObjectId: se le asigna el "id" de un documento que contiene ese "id"
      - ObjectId("67b295ecb59cc87d1bf2f2b8"): "id" pertenece a un [usuario]
  */


-- crear [tarea] y asignarsela a un [usuario]
db.tareas.insertOne(
  {
		usuarioId:ObjectId("67b295ecb59cc87d1bf2f2b8"),
		descripcion:"Preparar informe mensual",
		estado:"Pendiente"
	}
)
-- listar [tareas] de un [usuario] especifico
db.tareas.find(
  {
		usuarioId: ObjectId('67b295ecb59cc87d1bf2f2b8')
	}
)
--actualizar un "estado" de una [tarea]
db.tareas.updateOne(
  { _id:ObjectId('67b2b6ebb59cc87d1bf2f2bc')  },
  { $set: {estado:"Completada"} }
)
--actualizar "descripcion" de una [tarea] y "estado" de una [tarea]
db.tareas.updateOne(
  { _id:ObjectId("67b2b6ebb59cc87d1bf2f2bc") },
  { $set: {
      descripcion:"Preparar carta, para gerencia",
      estado:"Completada!!"
    }
  }
)
--AGREGAR CAMPO-DINAMCO, mediante una actualizacion
db.tareas.updateOne(
  { _id:ObjectId('67b2b6ebb59cc87d1bf2f2bc')  },
  { $set: {campoDinamicoNuevo:"Creamos un campo dinamico , solo a esta [TAREA]"} }
)

--borrar una [tarea],  tarea1="67b2b617b59cc87d1bf2f2bb"
db.tareas.deleteOne( {_id:ObjectId("67b2b617b59cc87d1bf2f2bb")} )

-- =============================================================================

/* IDs Personalizados
 * - _id       (id por defecto para cualquier DOCUMENTO de mongo)
 * - insertMany
 *    - opción `ordered: true` :  (que ninguno se inserte si hay algún error)
 *    - opción `ordered: false`:  ( insertar todos los documentos posibles, incluso si algunos fallan)
*/

--
db.createCollection("productos")
show collections
-- insertar multiples [productos]
db.productos.insertMany([
  { nombre:"arroz"   , precio:2000 },
  { nombre:"azucar"  , precio:3000 },
  { nombre:"Frijoles", precio:6000 }
])
--
db.productos.find()
-- ID_personalizado + insertar multiples [usuarios]
db.usuarios.insertMany([
  { _id:1, nombre:"Juan Perez" },
  { _id:2, nombre:"Rosa Gomez" },
])
-- no insertar ninguno, por _id repetido
--  - ordered: true   :inserta pero cuando encuentre un primer registro con error, para.
--  - ordered: false  :inserta los correctos, el que tenga error lo salta
db.usuarios.insertMany([
  { _id:2, nombre:"Bryan Cortes" },
  { _id:3, nombre:"Diego Barret" },
], { ordered: true })

-- =============================================================================

db.usuarios.insertMany([
  { nombre: "Juan Pérez",     edad: 35, correo: "juan@example.com" },
  { nombre: "María González", edad: 28, correo: "maria@example.com" },
  { nombre: "Pedro Ramírez",  edad: 42, correo: "pedro@example.com" },
  { nombre: "Ana Rodríguez",  edad: 31, correo: "ana@example.com" },
  { nombre: "Luisa Martínez", edad: 25, correo: "luisa@example.com" },
  { nombre: "Carlos Sánchez", edad: 40, correo: "carlos@example.com" },
  { nombre: "Sofía López",    edad: 22, correo: "sofia@example.com" },
  { nombre: "Andrés Torres",  edad: 33, correo: "andres@example.com" },
  { nombre: "Elena García",   edad: 29, correo: "elena@example.com" },
  { nombre: "Diego Jiménez",  edad: 38, correo: "diego@example.com" }
])

-- todos los documentos
db.usuarios.find()
db.usuarios.find({})
-- todos los documentos por filtro
-- [usuarios] por edad mayores a 30
db.usuarios.find({JSON.filter})
db.usuarios.find({ edad: {$gt: 30} })
-- [usuarios] por correo electronico
db.usuarios.find({ correo: "juan@example.com" })
-- [usuarios] por nombre exacto ó nombre especifico
db.usuarios.find({ nombre: "María González" })
-- [usuarios] por rango de edad (25 y 35) años
db.usuarios.find({ edad: {$gt:25, $lt:35} })
-- 
db.usuarios.find()
-- 
db.usuarios.find()
-- 
db.usuarios.find()
-- 
db.usuarios.find()





