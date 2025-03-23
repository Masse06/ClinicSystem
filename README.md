# Sistema de Gestión de Turnos de Clínica

## Descripción

Este proyecto es un **Sistema de Gestión de Turnos de Clínica** desarrollado en **Java**. Simula el proceso de gestionar los turnos de los pacientes en una clínica médica, permitiendo agregar nuevos turnos, atenderlos y guardarlos en archivos para su persistencia.

El sistema utiliza **Colas** para gestionar los turnos y **Lectura/Escritura de Archivos** para almacenar y recuperar los datos de los turnos. La aplicación proporciona una interfaz de consola interactiva para que los usuarios puedan agregar y atender turnos.

## Características

- **Agregar un nuevo turno:** Permite al usuario ingresar nueva información de pacientes y agregar un turno a la cola.
- **Atender un turno:** El usuario puede atender el primer turno en la cola, eliminándolo y guardándolo en un archivo de "turnos atendidos".
- **Persistencia de archivos:** La información de los turnos se guarda en un archivo para que los datos persistan entre ejecuciones del programa.
- **Gestión de la cola:** Los turnos se gestionan utilizando una estructura de datos de cola (FIFO), asegurando que el primer turno agregado sea el primero en ser atendido.

## Archivos

- **`turns_file`**: Un archivo que almacena todos los turnos pendientes.
- **`served_file`**: Un archivo que almacena todos los turnos atendidos.
