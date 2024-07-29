function printBoard(){
    let board = [
        ["X","|","O","|","X"],
        ["_","|","_","|","_"],
        ["O","|"," ","|","O"],
        ["_","|","_","|","_"],
        ["X","|","O","|","X"],
    ];
    for(let arrayCounter = 0; arrayCounter < board.length; arrayCounter++){
        for(let elementCounter = 0; elementCounter < board.length; elementCounter++){
            console.log(board[arrayCounter][elementCounter])
        }
    }
}
printBoard();
n