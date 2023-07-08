package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MineSweeperBoardTest : FunSpec({
    context("높이와 너비만큼의 게임판을 생성한다.") {
        val board = MineSweeperBoard(BoardSize(10, 15), 10)
        board.boardSize.width shouldBe 10
        board.boardSize.height shouldBe 15
    }

    context("지뢰는 0보다 많아야 한다.") {
        shouldThrow<IllegalArgumentException> {
            MineSweeperBoard(BoardSize(3, 3), -1)
        }
    }

    context("지뢰는 보드의 칸 수보다 적어야 한다.") {
        shouldThrow<IllegalArgumentException> {
            MineSweeperBoard(BoardSize(3, 3), 9)
        }
    }
})
