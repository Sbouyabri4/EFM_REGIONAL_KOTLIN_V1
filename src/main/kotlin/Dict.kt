class Dict {
    private val entries = arrayListOf<Ent>()

    fun nombreEntrees(): Int {
        return entries.size
    }

    fun ajouter(e: Ent) {
        if (entries.contains(e)) {
            throw IllegalArgumentException("L'entrée existe déjà dans le dictionnaire.")
        }
        entries.add(e)
    }

    fun supprimer(e: Ent): Boolean {
        return entries.remove(e)
    }

    fun supprimer(motAnglais: String): Boolean {
        val e = entries.find { it.motAnglais == motAnglais }
        return if (e != null) {
            entries.remove(e)
            true
        } else {
            false
        }
    }

    fun frAn(motFrancais: String): ArrayList<String> {
        val result = arrayListOf<String>()
        for (e in entries) {
            if (e.motFrancais == motFrancais) {
                result.add(e.motAnglais)
            }
        }
        return result
    }

    fun motsFrancais(): ArrayList<String> {
        val result = arrayListOf<String>()
        for (e in entries) {
            if (!result.contains(e.motFrancais)) {
                result.add(e.motFrancais)
            }
        }
        return result
    }

    fun dictionnaireFrAn(): Map<String, ArrayList<String>> {
        val result = hashMapOf<String, ArrayList<String>>()
        for (e in entries) {
            val mots = result.getOrDefault(e.motFrancais, arrayListOf())
            mots.add(e.motAnglais)
            result[e.motFrancais] = mots
        }
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (e in entries) {
            sb.append("$e\n")
        }
        return sb.toString()
    }
}
