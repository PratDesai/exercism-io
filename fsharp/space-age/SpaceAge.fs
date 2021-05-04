module SpaceAge

[<Measure>]
type earthYear

[<Measure>]
type second

type Planet =
    | Mercury
    | Venus
    | Earth
    | Mars
    | Jupiter
    | Saturn
    | Uranus
    | Neptune

let age (planet: Planet) (seconds: int64) : float =
    planet
    |> function
    | Mercury -> 0.2408467<earthYear>
    | Venus -> 0.61519726<earthYear>
    | Earth -> 1.0<earthYear>
    | Mars -> 1.8808158<earthYear>
    | Jupiter -> 11.862615<earthYear>
    | Saturn -> 29.447498<earthYear>
    | Uranus -> 84.016846<earthYear>
    | Neptune -> 164.79132<earthYear>
    |> (*) 31557600.0<second/earthYear>
    |> (/) ((float seconds) * 1.0<second>)
