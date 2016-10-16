## DESCRIPCIÓN DEL PROYECTO
Proyecto Integrador 2 UPN: Solución web y móvil bajo una aqruitectura basada en adaptadores para la entidad San Lorenzo LTDA, se implementa el módulo de aprobación de créditos. Para el presente proyecto se desarrollo bajo el lenguaje Java tanto en web como en móvil, la parte Web se usó Spring Framework.

## ARQUITECTURA PLANTEADA PARA EL PROYECTO
La arquitectura del proyecto está basada en MVC como patron de diseño y e N-Capas como arquitectura, pero para dar una solución mucho más eficiente se desarrolla un módulo adaptador para las entidades, para poder hacer un mejor mantenimiento del software y permitir el bajo acoplamiento. Esta misma arquitectura por medio de un servicio web se puede enlazar a la aplicación de Android como se puede apreciar en el "Módulo App", de esta manera reutilizamos los componentes y no tenemos que crear nuevos modelos, sino haciendo uso de las interfaces IDTO que brinda el módulo adaptador se logra esto.
Descripción gráfica de la arquitectura.
![image](https://cloud.githubusercontent.com/assets/7152507/19419502/9d009896-939e-11e6-8986-4d1fa0d98a86.png)

## APLICACIÓN WEB (vista general)

![afiliar_persona](https://cloud.githubusercontent.com/assets/7152507/19419574/04b1590c-93a0-11e6-9719-39eb4509f961.png)

![expediente_credito](https://cloud.githubusercontent.com/assets/7152507/19419575/04b6c5a4-93a0-11e6-9995-8c622ff45b5f.png)

## APLICACIÓN MÓVIL (vista general)

![image](https://cloud.githubusercontent.com/assets/7152507/19419581/5df40e42-93a0-11e6-97c6-0caaf0e0da9a.png)

![detalle_aprobacion](https://cloud.githubusercontent.com/assets/7152507/19419590/891a0e0a-93a0-11e6-8e5d-60cb8e3897d8.png)
