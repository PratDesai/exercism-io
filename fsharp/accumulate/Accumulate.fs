module Accumulate

let rec accumulate (func: 'a -> 'b) (input: 'a list) : 'b list =
    let rec map (mapFunc: 'a -> 'b) (input: 'a list) (acc: 'b list) =
        match input with
        | [] -> List.rev acc
        | x :: rest -> map mapFunc rest ((func x) :: acc)

    map func input []
