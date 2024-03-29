# PIGrupo-4_Escritorio

## REPOSITORIOS

- Aplicación de Escritorio: <https://github.com/JeronimoRP/PIGrupo-4_Escritorio>
- API: <https://github.com/JeronimoRP/PIGrupo-4_API>
- Android: <https://github.com/JeronimoRP/PIGrupo-4_Android>

## Índice

- [API](#api)
  - [Incidencias Subtipo Controller](#incidencias-subtipo-controller)
  - [Personal Controller](#personal-controller)
  - [Perfile Controller](#perfile-controller)
  - [Incidencia Controller](#incidencia-controller)
  - [Equipo Controller](#equipo-controller)
  - [Departamento Controller](#departamento-controller)
  - [Comentario Controller](#comentario-controller)
  - [Aula Controller](#aula-controller)
  - [Schemas](#schemas)
- [Python](#python)
  - [archivo](#archivo)
  - [Access](#access)
  - [Incidencia](#incidencia)
  - [Main](#main)
- [Android](#android)
  - [Rasgos Generales](#rasgos-generales)
  - [Login](#login)
  - [Lista Resumen](#lista-resumen)
  - [Lista Completa](#lista-completa)
  - [Añadir](#añadir-y-editar)
- [Tecnologías Utilizadas en el Proyecto](#tecnologías-utilizadas-en-el-proyecto)

## API

### Incidencias Subtipo Controller

#### `PUT /subtipos/{id}`

Actualizar un subtipo de incidencia por ID.

#### `DELETE /subtipos/{id}`

Eliminar un subtipo de incidencia por ID.

#### `GET /subtipos`

Obtener la lista de subtipos de incidencia.

#### `POST /subtipos`

Crear un nuevo subtipo de incidencia.

### Personal Controller

#### `PUT /personal/update/{id}`

Actualizar información de personal por ID.

#### `POST /personal/save`

Registrar nuevo personal.

#### `GET /personal/perfil/{id}`

Obtener el perfil de un miembro del personal por ID.

#### `GET /personal/nombre/apellidos`

Obtener la lista de personal ordenado por nombre y apellidos.

#### `GET /personal/login`

Obtener información de inicio de sesión del personal.

#### `GET /personal/listaPersonal`

Obtener la lista completa de personal.

#### `GET /personal/infoPersonal/{id}`

Obtener información detallada de un miembro del personal por ID.

#### `DELETE /personal/delete/{id}`

Eliminar un miembro del personal por ID.

### Perfile Controller

#### `PUT /perfile/{id}`

Actualizar información de perfil por ID.

#### `DELETE /perfile/{id}`

Eliminar un perfil por ID.

#### `GET /perfile`

Obtener la lista de perfiles.

#### `POST /perfile`

Crear un nuevo perfil.

#### `GET /perfile/{dominio}`

Obtener información de un perfil por dominio.

### Incidencia Controller

#### `PUT /incidencias/update`

Actualizar una incidencia.

#### `POST /incidencias/save`

Registrar una nueva incidencia.

#### `POST /incidencias/asignarincidencia`

Asignar una incidencia.

#### `GET /incidencias/incidencias`

Obtener la lista de todas las incidencias.

#### `GET /incidencias/incidencias/{creadorId}`

Obtener incidencias creadas por un ID de creador.

#### `GET /incidencias/generatepdf`

Generar un PDF de incidencias.

#### `GET /incidencias/generate-pdf-tiempo-total`

Generar un PDF con estadísticas de tiempo total de incidencias.

#### `GET /incidencias/generate-pdf-incidencias-por-admin`

Generar un PDF con incidencias clasificadas por administrador.

#### `GET /incidencias/generarexcel`

Generar un archivo Excel con datos de incidencias.

#### `GET /incidencias/generar-pdf-tiempo-incidencias`

Generar un PDF con estadísticas de tiempo de incidencias.

#### `GET /incidencias/generar-pdf-porcentaje-tiempo`

Generar un PDF con estadísticas de porcentaje de tiempo de incidencias.

#### `GET /incidencias/generar-pdf-incidencias-abiertas`

Generar un PDF con incidencias abiertas.

#### `GET /incidencias/generar-excel-incidencias-por-administrador`

Generar un archivo Excel con incidencias clasificadas por administrador.

#### `GET /incidencias/generar-excel-incidencias-abiertas`

Generar un archivo Excel con incidencias abiertas.

#### `GET /incidencias/generar-excel-estadistica-tiempo-y-numero`

Generar un archivo Excel con estadísticas de tiempo y número de incidencias.

#### `GET /incidencias/generar-excel-estadistica-tiempo-por-tipo`

Generar un archivo Excel con estadísticas de tiempo por tipo de incidencia.

#### `GET /incidencias/generar-excel-estadistica-tiempo-por-administrador`

Generar un archivo Excel con estadísticas de tiempo por administrador.

#### `GET /incidencias/generar-excel-estadistica-por-tipo`

Generar un archivo Excel con estadísticas por tipo de incidencia.

#### `GET /incidencias/filtro`

Obtener incidencias filtradas.

#### `GET /incidencias/abiertas`

Obtener la lista de incidencias abiertas.

#### `DELETE /incidencias/delete/{id}`

Eliminar una incidencia por ID.

### Equipo Controller

#### `GET /eq/{id}`

Obtener información de un equipo por ID.

#### `PUT /eq/{id}`

Actualizar información de un equipo por ID.

#### `DELETE /eq/{id}`

Eliminar un equipo por ID.

#### `POST /eq`

Crear un nuevo equipo.

#### `GET /eq/equipos`

Obtener la lista de equipos.

### Departamento Controller

#### `GET /dep/{id}`

Obtener información de un departamento por ID.

#### `PUT /dep/{id}`

Actualizar información de un departamento por ID.

#### `DELETE /dep/{id}`

Eliminar un departamento por ID.

#### `POST /dep`

Crear un nuevo departamento.

#### `GET /dep/departamentos`

Obtener la lista de departamentos.

### Comentario Controller

#### `PUT /coment/update/{id}`

Actualizar un comentario por ID.

#### `POST /coment/save`

Crear un nuevo comentario.

#### `GET /coment/comentarios`

Obtener la lista de todos los comentarios.

#### `GET /coment/comentarios-por-incidencia`

Obtener comentarios por incidencia.

#### `GET /coment/comentario/{id}`

Obtener información detallada de un comentario por ID.

#### `DELETE /coment/delete/{id}`

Eliminar un comentario por ID.

### Aula Controller

#### `GET /api/{id}`

Obtener información de un aula por ID.

#### `PUT /api/{id}`

Actualizar información de un aula por ID.

#### `DELETE /api/{id}`

Eliminar un aula por ID.

#### `POST /api`

Crear una nueva aula.

#### `GET /api/aulas`

Obtener la lista de aulas.

## Schemas

- IncidenciasSubtipo
- Departamento
- Personal
- Perfile
- ComentarioDto
- IncidenciaDto
- IncidenciaSubtipoDto
- PersonalDto
- Aula
- Equipo
- PersonalInputDto
- PersonalOutputDto
- IncidenciaFilterDto
- Comentario
- Incidencia

## Python

La aplicacion controla el tiempo invertido en una incidencia recogiendo via la api las incidencias abiertas y luego manteniendo registro del tiempo trabajado en cada incidencia

### Archivo

Clase utilizada para manejar la lectura y escritura del archivo binario en el que se guarda la informacion

Carpeta donde se guardan las incidencias

``` cmd
%UserProfile%/Incidencias
```

esta carpeta solo existe una vez ejecutada la aplicación

### Access

Clase utilizada para la llamada hacia la api  en la cual recoge todas las incidencias abiertas y la devuelve en una lista en este orden:

1. Envía una solicitud GET a la API local en <http://localhost:8080/incidencias/incidencias>.
2. Imprime el código de estado de la respuesta.
3. Inicializa una lista vacía llamada num_list para almacenar los números de incidentes.
4. Si el código de estado de respuesta es 200 (OK), continúa analizando la respuesta JSON y extrayendo el campo num de cada elemento, agregándolo a la num_list.
5. Devuelve la num_list si el código de estado de respuesta es 200, o None si hay un error (código de estado no 200) o si la solicitud no se puede realizar (por ejemplo, debido a una falta de conexión a internet).

``` py
def getNumlist():
        response = requests.get("http://localhost:8080/incidencias/incidencias")
        print(response.status_code)
        num_list = []  
        if response.status_code == 200:
            data = response.json()
            for element in data:
                num_list.append(element['num'])
            return num_list
        else :
            print("Error la acceder a la base datos compruebe su conexion a internet")
            return None

```

### Incidencia

Clase utilizada para almacenar la informacion de las incidencias contado su identificador y el tiempo de inicio y de cierre de esta mediante metodo de inico, cierre y diferecia

``` py
    def iniciar(self):
        """
        Inicia la incidencia si no está activa.
        """
        if self.tiempo_activo is None:
            self.fecha_inicio = datetime.datetime.now()
            print(f"Incidencia {self.identificador} iniciada a las {self.fecha_inicio}")
        else:
            print(f"Incidencia {self.identificador} ya estaba activa")

    def finalizar(self):
        """
        Finaliza la incidencia si está activa.
        """
        if self.fecha_inicio is None:
            print(f"Incidencia {self.identificador} no estaba activa")
        else:
            self.fecha_fin = datetime.datetime.now()
            self.tiempo_activo = self.fecha_fin - self.fecha_inicio
            print(f"Incidencia {self.identificador} finalizada. Tiempo activo: {self.tiempo_activo}")

    def calcular_tiempo_activo(self):
        """
        Calcula y devuelve el tiempo activo de la incidencia si está activa.
        Si no está activa, devuelve un mensaje de error.
        """
        if self.fecha_inicio is not None and self.fecha_fin is not None:
            self.tiempo_activo = self.fecha_fin - self.fecha_inicio
            return self.tiempo_activo
        else:
            return "La incidencia no ha sido finalizada o no ha sido iniciada"
```

### Main

Inicia obteniendo la lista de incidencias abiertas lo recoge la incidencia en la que se quiere trabajar despues inicia el tiempo de la incidencia

``` py
numList = Access.getNumlist()
print("Mostrando incidencias activas")
if numList is not None:
    print(numList)
    # Solicitar el identificador de la incidencia
    id = input("Identificador de la incidencia \n")
    # Nombre del archivo donde se guardará la incidencia
    filename = id + ".dat"
    # Leer la incidencia desde el archivo
    incident = archivo.leerArchivo(filename)
    # Si no se encuentra la incidencia en el archivo, crear una nueva incidencia con el identificador dado
    if incident is None:
        incident = Incidencia(id)
    # Iniciar la incidencia
    incident.iniciar()
    # Mostrar mensaje indicando que se está iniciando el trabajo
    print("Iniciando trabajo")
    # Esperar a que el usuario pulse una tecla para finalizar el trabajo
    input("Pulsa cualquier tecla para finalizar el trabajo")
    # Finalizar la incidencia
    incident.finalizar()
    # Calcular el tiempo activo de la incidencia
    tiempo_activo = incident.calcular_tiempo_activo()
    # Escribir la incidencia en el archivo
    archivo.escribirArchivo(incident, filename)
    print("Incidencia guardada, que tenga buen dia")
```

## Android

La aplicacion movil en una aplicacion informativa con la capacidad de mostrar,agregar, eliminar y editar

### Rasgos Generales

La mayoria de actividades cuenta con un navigation drawer que permite el acceso rapido y sencillo a las actividades de  listado resumen, listado completo y añadir este drawer se inicializa en todas las actividades de inicio de sesion  

### Login

Pide al usuario su correo de Educantabria y su contraseña despues envia una peticion a la API para verificar su existencia 

### Lista Resumen
Muestra de manera resumioda todas las incidencias que a abierto el usuario permitiendole editar las abierta y elimina.
Utiliza un rcycleview con un adaptador y Hoder personalizado con imagecard para darle la estetica ademas de contar con el Navigation Drawer

### Lista Completa

Muestra de manera completa todas las incidencias que a abierto el usuario mostrandole las fechas de en las que se a abierto y cerrado las incidencias.
Utiliza un rcycleview con un adaptador y Hoder personalizado con imagecard para darle la estetica ademas de contar con el Navigation Drawer

### Añadir y Editar

Se añade o se edita una incidencia enviando hacia la api los datos de la nueva incidencia y actualizando las listas de las que las recycle view utilizan en el caso 


## Informe sobre la Implementación de PSP (Perfil de Usuario) en la Aplicación:

### Escritorio

**1. Introducción:**
La implementación del Perfil de Usuario (PSP) en la aplicación se ha llevado a cabo con el objetivo de personalizar la experiencia del usuario y garantizar la seguridad de la información. En este informe, se detallan los pasos realizados en las etapas 5.4, 5.5 y 5.6 del desarrollo.

**2. Verificación del Tipo de Perfil del Usuario (Etapa 5.4):**
Se realizó una verificación en la base de datos para determinar el tipo de perfil que posee cada usuario al iniciar sesión. Esta fase es crucial para asegurar que el acceso a la aplicación se ajuste a las necesidades y privilegios específicos de cada usuario. Se implementaron tres posibles escenarios:
   
   - **Mensaje de Error para Usuarios No Registrados:**
     Si el usuario no se encuentra en la base de datos, se activa un mensaje de error indicando la falta de registro. Esto garantiza que solo usuarios autorizados tengan acceso.

   - **Interfaz del Profesor:**
     Si el perfil del usuario corresponde al de un profesor, la aplicación se inicia con la interfaz diseñada para este grupo de usuarios. Esto facilita una experiencia adaptada a las funciones y responsabilidades del profesor.

   - **Interfaz del Administrador:**
     Para los usuarios con perfil de administrador, la aplicación se inicia con una interfaz específica que proporciona acceso a funciones administrativas y controles avanzados.
  
**3. Encriptación de Archivos Adjuntos (Etapa 5.5):**
Se implementó un método de seguridad robusto mediante la encriptación de archivos adjuntos que contienen incidencias y comentarios. Estos archivos se codificaron en formato base 64 para asegurar la confidencialidad y la integridad de la información. Esta medida refuerza la protección contra accesos no autorizados y garantiza que la información sensible permanezca segura durante la transmisión y el almacenamiento.

**4. Recolección de Perfil de Usuario mediante el Dominio (Etapa 5.6):**
La aplicación recopila el perfil del usuario identificando el dominio desde el cual se ha iniciado sesión. Esta información se utiliza para personalizar la experiencia del usuario según sus atributos y roles asociados con el dominio específico. La recolección del perfil a través del dominio simplifica el proceso y garantiza una adaptación precisa a las necesidades del usuario.

**5. Conclusiones:**
La implementación exitosa de estas etapas fortalece la seguridad, personalización y eficiencia de la aplicación. La combinación de verificación de perfil, encriptación de archivos y recolección de datos basada en dominio crea un entorno robusto y adaptativo para los usuarios, asegurando un acceso seguro y una experiencia óptima.

### API

**Generación del Salt y Encriptación de Contraseñas:**
**Generación del Salt:**
Se utiliza el método generarSalt() para generar un salt aleatorio, una cadena única y aleatoria. Este valor se concatenará a la contraseña antes de realizar el hash, proporcionando un nivel adicional de seguridad.

``` py
java
Copy code
private String generarSalt() {
    SecureRandom random = new SecureRandom();
    byte[] saltBytes = new byte[16];
    random.nextBytes(saltBytes);
    return bytesToHex(saltBytes);
}
```

**Encriptación de la Contraseña:**

**Concatenación de Salt y Contraseña:**

La contraseña original se combina con el salt generado utilizando la variable contrasenaConSalt.
Uso del Algoritmo de Hash SHA-256:

Se utiliza el algoritmo de hash SHA-256 para calcular el hash de la contraseña concatenada. Este proceso asegura que la contraseña no se almacene en texto plano, agregando una capa adicional de seguridad.

``` py
java
Copy code
private String encriptarContrasena(String contrasena, String salt) {
    String contrasenaConSalt = salt + contrasena;
    try {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = messageDigest.digest(contrasenaConSalt.getBytes());
        return bytesToHex(hashBytes);
    } catch (NoSuchAlgorithmException e) {
        // Manejar la excepción de manera adecuada (puede lanzar una excepción personalizada o registrar el error)
        e.printStackTrace();
        return null;
    }
}

```
Conversión de Bytes a Hexadecimal:
El resultado del hash se convierte a una representación hexadecimal mediante el método bytesToHex().

``` py
java
Copy code
private String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte b : bytes) {
        hexString.append(String.format("%02x", b));
    }
    return hexString.toString();
}
```


# Tecnologías Utilizadas en el Proyecto

En este proyecto, hemos utilizado diversas tecnologías para construir y desarrollar la aplicación de gestión de incidencias. A continuación, se presentan algunas de las principales tecnologías utilizadas:

### [Psotman](https://www.postman.com/)

![Logo Psotman](URL_del_logo_1)

Postman es una herramienta de desarrollo de API que facilita la creación y prueba. Diseñada para simplificar el proceso de trabajo con APIs, Postman ofrece una interfaz de usuario intuitiva que permite a los desarrolladores realizar diversas acciones relacionadas con las API de forma eficiente.

### [IntelliJ IDEA Community Edition 2022.2.1](https://www.jetbrains.com/ides/)

![Logo IntelliJ](URL_del_logo_2)

IntelliJ IDEA es un entorno de desarrollo integrado (IDE) utilizado para la creación eficiente de software en Java y otros lenguajes. Proporciona herramientas avanzadas de desarrollo, refactorización, depuración y soporte para una amplia gama de tecnologías, facilitando la escritura, prueba y mantenimiento de código.

### [Visual Studio](https://visualstudio.microsoft.com/es/)

![Logo Visual Studio](URL_del_logo_3)

Visual Studio es un entorno de desarrollo integrado (IDE) desarrollado por Microsoft. Sirve como una plataforma completa para el desarrollo de software, que abarca una variedad de lenguajes de programación y tecnologías.

### [Android Studio](https://developer.android.com/studio?hl=es-419)

![Logo Android Studio](URL_del_logo_3)

Android Studio es un entorno de desarrollo integrado (IDE) creado por Google para facilitar y potenciar el desarrollo de aplicaciones móviles en la plataforma Android. Con un enfoque centrado en la eficiencia y la productividad, Android Studio ofrece una serie de características y funcionalidades esenciales para los desarrolladores de Android.

