package org.example.br.com.alugames.modelo

//classe de armazenamento para nao ficar mudando
data class InfoJogo(val info: InfoApiShrak) {
    override fun toString(): String {
        return info.toString()
    }
}