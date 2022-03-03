# Evaluación reto 1

## Hace todos los puntos pedidos (40%)

#### Dado un nombre vía argumento, devolver sus tipos

OK

#### Dado un nombre vía endpoint, devolver sus tipos

OK

#### Si no existe el pokemon, ¿se lanza una excepción de dominio?

OK

#### Si la api da timeout, ¿se lanza una excepción de dominio?

- OK. Pero el nombre de la excepción de dominio tiene que ser lo suficientemente clara para que no necesitéis indicar
  cuál ha sido el error real a través del constructor. Ejemplo: en vez de tener un `RepositoryException` lo correcto
  sería tener un `RepositoryNotResponding` y así no se indica ningún detalle de implementación 😉

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP/un error legible en consola?

- Por CMD: Se muestra un mensaje aunque siempre con el prefijo `Error:`

- Por HTTP: Devuelve un mensaje de error, pero todo devuelve un 500, debería devolver un código de error esperado.
  Ejemplo: 404 not found

**Error principal: Usar lenguaje de infraestructura en `RepositoryException` que es de dominio**

**Puntuación final: 35/40**

## Se aplican conceptos explicados (40%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

OK

#### Aggregates + VOs

- `TypesDTO` no se está usando, además, en el caso de tener DTOs estos deberían estar en application
- Existe el ¿VO? ¿Agregado? `Type` y el VO PokemonName `Name` pero dentro de `Type`, suponiendo que éste sea el
  agregado, el `name` debería ser un VO también. Ya que un agregado se compone de Value Objects + Entities (en este
  caso, solo Value Objects).

#### No se trabajan con tipos primitivos en dominio

- La capa de dominio debería ser una capa, en general, "libre de primitivos". Ya que la gran mayoría de estos deberían
  estar encapsulados en Value Objects tal y como explicaba en el punto anterior.

#### Hay servicios de dominio

- OK, aunque sería un searcher en vez de un finder, ya que está buscando los objetos que contengan o cumplan las
  condiciones 😉.

#### Hay use cases en aplicación reutilizables

OK

#### Se aplica el patrón repositorio

OK

**Error principal: No hay agregado que se componga de VOs**

**Puntuación final: 30/40**

## Facilidad setup + README (20%)

#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo usar la aplicación"

- OK. Aunque el comando correcto para ejecutar el clean install de maven es el siguiente: `./mvnw clean install` y para
  ejecutar comandos de la aplicación: `./mvnw spring-boot:run` (desde la raíz del proyecto)
- No hace falta especificar nada del directorio target

#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"

- OK, pero se agradecería usar más comillas o saltos de línea para separar el texto de los comandos.

**Puntuación final: 13/20**

## Observaciones

- El proyecto no tiene el nombre pedido `mdas-api-g4`
- No nombréis las interfaces como `IBlabla`. Es un estándar obsoleto hoy en día (salvo que sea algún tipo de convención
  del lenguaje, que en Java no lo es).
- Usad
  el [estándar](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Why-you-should-make-kebab-case-a-URL-naming-convention-best-practice)
  de escritura de URLs (kebab case). Ej: `/pokemon-type` o `/type` pasándole el `name` como un query param

**PUNTUACIÓN FINAL: 78/100**
