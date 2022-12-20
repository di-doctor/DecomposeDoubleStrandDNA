fun main() {
    val con = ContexState(state = SolidState())
    con.heat()
    con.heat()
    con.heat()
    con.freeze()
    con.freeze()
    con.freeze()
}

interface State {
    val name: String
    fun freeze(contexState: ContexState)
    fun heat(contexState: ContexState)
}

class SolidState : State {
    override val name: String
        get() = "Solid"

    override fun freeze(contexState: ContexState) {
        println("Ничего не меняется")
    }

    override fun heat(contexState: ContexState) {
        contexState.state = LiquidState()
    }

    override fun toString(): String {
        return name
    }
}

class LiquidState : State {
    override val name: String
        get() = "Liquid"

    override fun freeze(contexState: ContexState) {
        contexState.state = SolidState()
    }

    override fun heat(contexState: ContexState) {
        contexState.state = GasState()
    }

    override fun toString(): String {
        return name
    }

}

class GasState : State {
    override val name: String
        get() = "Gas"

    override fun freeze(contexState: ContexState) {
        contexState.state = LiquidState()
    }

    override fun heat(contexState: ContexState) {
        println("Ничего не меняется")
    }

    override fun toString(): String {
        return name
    }

}

class ContexState(state: State) {
    var state = state
        set(value) {
            field = value
            println("Состояние изменилось на $state")
        }

    fun freeze() {
        println("Охлаждение материала в состоянии $state")
        state.freeze(this)
    }

    fun heat() {
        println("Нагрев материала в состояни $state")
        state.heat(this)
    }
}
