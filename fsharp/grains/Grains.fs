module Grains

let square =
    function
    | x when x < 1 || x > 64 -> Error "square must be between 1 and 64"
    | x -> Ok(1UL <<< x - 1)

let total : Result<uint64, string> = Ok System.UInt64.MaxValue

let totalCalculated : Result<uint64, string> =
    let extract =
        function
        | Ok x -> x
        | Error _ -> 0UL

    [ 1 .. 64 ]
    |> List.map square
    |> List.sumBy extract
    |> Ok

(*  The following function (sourced from mazhuravlev's solution) 
    with error propagation is not strictly necessary as the list 
    of integers mapped with the square function is generated 
    internally, and is within the acceptable input range 
    of numbers for the square function. *)
let totalCalculatedWithErrorPropagation : Result<uint64, string> =
    [ 1 .. 64 ]
    |> List.map square
    |> List.reduce
        (fun a b ->
            match (a, b) with
            | (Ok a, Ok b) -> Ok(a + b)
            | (Error a, _) -> Error a
            | (_, Error b) -> Error b)
