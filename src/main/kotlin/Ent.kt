class Ent(motAnglais: String, motFrancais: String) {
    var motAnglais: String = ""
        set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException("Le mot anglais ne peut pas être vide ou null.")
            }
            field = value.trim()
        }
    var motFrancais: String = ""
        set(value) {
            if (value.isBlank()) {
                throw IllegalArgumentException("Le mot français ne peut pas être vide ou null.")
            }
            field = value.trim()
        }

    init {
        this.motAnglais = motAnglais
        this.motFrancais = motFrancais
    }

    override fun toString(): String {
        return "$motAnglais:$motFrancais"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val ent = other as Ent

        return motAnglais == ent.motAnglais
    }
}
