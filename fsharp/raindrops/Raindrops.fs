module Raindrops

let rainDropSounds =
    [ (3, "Pling")
      (5, "Plang")
      (7, "Plong") ]

let convert (number: int) : string =
    let isRainSound (f, _) = number % f = 0
    let getSound (_, s) = s

    rainDropSounds
    |> List.filter isRainSound
    |> List.map getSound
    |> List.fold (+) ""
    |> function
    | "" -> $"{number}"
    | s -> s
