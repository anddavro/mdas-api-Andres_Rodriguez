## Hace todos los puntos pedidos (40%)

#### Permite crear usuarios vía endpoint

OK

#### Permite añadir favoritos vía endpoint

OK

#### Si el pokemon ya está marcado como favorito, ¿se lanza una excepción de dominio?

OK

#### Si el usuario no existe, ¿se lanza una excepción de dominio?

- Se está delegando la responsabilidad de crear ids de usuarios a la API en vez de al cliente. Tal y como está hecho, no
  es un sistema idempotente. Por tanto, nunca se va a cumplir este punto

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP?

OK

#### Hay tests unitarios

- Si la entidad `Favorites` tiene lógica de dominio, debería estar testeada.

**Puntuación: 33/40**

## Se aplican conceptos explicados (50%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

OK

#### Aggregates + VOs

OK

#### No se trabajan con tipos primitivos en dominio

OK

#### Hay servicios de dominio

- El servicio de dominio `UserAdderPokemon` debería ser el encargado de llamar al `UserFinder` y no el application
  service `AddFavoriteUseCase`. El servicio de dominio `UserAdderPokemon` debería ser quien recibiera como argumentos
  los VOs o entidades necesarias, y dentro de este, debería buscar el agregado `User`.
- Si creas el usuario con datos que no decide el cliente, ¿qué sentido tiene esta validación?:

```
User user  = new User();
validateExists(user);
```

#### Hay use cases en aplicación reutilizables

OK

#### Se aplica el patrón repositorio

- OK, aunque yo no llamaría `interfaces` al package, como mucho lo llamaría ports. Y a la implementación
  del `UserRepository` se le debería añadir un prefijo de la implementación, ejemplo: `InMemoryUserRepository`.

#### Se utilizan object mothers

- No

**Error principal: Responsabilidad incorrecta en la capa de aplicación**
**Puntuación: 35/50**

## Facilidad setup + README (10%)

#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo user la aplicación"

OK

#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"

OK

**Puntuación: 10/10**

## Observaciones

- El proyecto sigue llamándose `pokemon` en vez de `mdas-api-g4`
- Las URLs no deberían tener la acción a realizar en el nombre. Si hacemos un POST `/users` está claro que es un
  endpoint de creación.

**PUNTUACIÓN FINAL: 78/100**
