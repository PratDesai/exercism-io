module Pangram

let isPangram (input: string) : bool =
    [ 'a' .. 'z' ]
    |> Seq.forall (input.ToLower().Contains)
