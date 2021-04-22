module Raindrops

let rainDropSounds =
    [ (3, "Pling")
      (5, "Plang")
      (7, "Plong") ]

let convert (number: int) : string =
    rainDropSounds
    |> List.filter (fun (f, _) -> number % f = 0)
    |> List.map snd
    |> List.fold (+) ""
    |> function
    | "" -> $"{number}"
    | s -> s
