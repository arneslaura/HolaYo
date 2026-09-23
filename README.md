# Laboratorios 1 y 2 - Aplicaciones Móviles

*La resolución y el código de cada laboratorio se encuentran separados en distintos commits dentro del historial de este repositorio.*

**Alumna:** Laura Arnés  
**Proyecto:** HolaYo  
**SDK Mínimo:** API 26 (Android 8.0)

## Laboratorio 1: El taller y el primer proyecto 

### Checklist de salida completado:
- [x] Android Studio instalado y operativo.
- [x] Proyecto creado (Empty Views Activity, minSdk 26).
- [x] Aplicación corriendo en emulador y dispositivo físico.
- [x] **Desafíos Opcionales completados:**
    - Ícono personalizado (resoluciones generadas en `mipmap`).
    - Instalación de APK vía transferencia directa verificando el modelo de confianza (Play Protect / orígenes desconocidos).
    - Implementación de tercer dato opcional ("equipoFutbol") gestionado de forma segura con `?.let { }` en Kotlin.

### Detalles del APK (Lab 1)
- **Ruta de compilación:** `app/build/outputs/apk/debug/app-debug.apk`
- **Peso del archivo final:** 5.685 KB
- **Enlace de descarga:** https://github.com/arneslaura/HolaYo/releases/tag/v1.0-lab1

---
## Laboratorio 2: Una pantalla que vive y muere

### Checklist de salida completado:
- [x] HolaYo tiene dos pantallas conectadas por un Intent explícito que lleva un dato.
- [x] Ambas Activities instrumentadas; lectura del entrelazado de la navegación en Logcat.
- [x] Tabla de la tortura completa, con predicciones escritas antes de cada observación.
- [x] Recreación por giro presenciada: secuencia en el log analizada, contador perdido (variables de la instancia) y frase sobreviviente (estado de vistas resguardado por ID).
- [x] Proceso asesinado mediante ADB simulando presión de memoria, verificación de PID nuevo al renacer y análisis de la reconstrucción parcial del sistema.
- [x] Ejecución detenida con un breakpoint e inspección de variables en vivo mediante el Depurador.
- [x] **Desafíos Opcionales completados:**
  - Instrumentación de `onRestart` y análisis de su redundancia frente a `onStart` en el regreso desde segundo plano.
  - Implementación de Intent implícito (`ACTION_SEND`) con `createChooser` para compartir el perfil con el ecosistema de aplicaciones del dispositivo mediante texto plano.
  - Salvataje del estado implementando `onSaveInstanceState` para empaquetar el valor del contador y restaurarlo en el `onCreate` tras la destrucción.
  - Análisis de la "tortura del que está abajo": comprobación de la recreación perezosa de `MainActivity` en la pila de retroceso tras matar el proceso.

### Herramientas y comandos técnicos aplicados
- **Android Debug Bridge (ADB):** Ejecución por terminal de `.\adb -d shell am kill com.example.holayo` apuntando específicamente al dispositivo físico (Motorola Moto G52) para forzar la muerte por memoria en segundo plano.
- **Logcat:** Instrumentación mediante `Log.d` y filtrado estricto (`tag: VIDA`) para trazar la historia de la navegación y las destrucciones silenciosas.
- **Depurador (Debugger):** Congelamiento del hilo de ejecución en eventos de la interfaz, avance paso a paso (Step Over / F8) e inspección profunda del panel de variables vivas en memoria (`this$0`).

### Detalles del APK (Lab 2)
- **Enlace de descarga:** https://github.com/arneslaura/HolaYo/releases/tag/v2.0-lab2