module Grains

let square =
    function
    | x when x < 1 || x > 64 -> Error "square must be between 1 and 64"
    | x -> Ok(pown 2UL ((int x) - 1))

let total : Result<uint64, string> =
    let extract =
        function
        | Ok x -> x
        | Error _ -> 0UL

    [ 1 .. 64 ]
    |> List.map square
    |> List.sumBy extract
    |> Ok

(* The following total function with error check is not necessary as the list
of integers mapped with the square function is generated internally,
and is within the acceptable input range of numbers of the square function. *)
let totalWithErrorCheck : Result<uint64, string> =
    let extract =
        function
        | Ok x -> x
        | Error _ -> 0UL

    let squares = List.map square [ 1 .. 64 ]

    match squares with
    | list when
        List.forall
            (function
            | Ok _ -> true
            | Error _ -> false)
            list -> list |> List.sumBy extract |> Ok
    | list ->
        List.find
            (function
            | Error _ -> true
            | _ -> false)
            list
