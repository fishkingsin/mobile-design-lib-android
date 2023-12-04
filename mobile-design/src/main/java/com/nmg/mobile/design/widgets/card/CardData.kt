package com.nmg.mobile.design.widgets.card

public abstract class CardDataProtocol(
    open val id: Int,
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    override val tag: String? = null,
    private val _timecode: String? = null
) : CardDisplayable, TimecodeDisplayable {
    override val timecode: String
        get() = _timecode ?: "--:--"
}

public data class CardData(
    override val id: Int,
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    override val tag: String? = null,
    val _timecode: String? = null
) : CardDataProtocol(
    id = id,
    imageURL = imageURL,
    headline = headline,
    leadingFootnote = leadingFootnote,
    secondFootnote = secondFootnote,
    _timecode = _timecode
)
