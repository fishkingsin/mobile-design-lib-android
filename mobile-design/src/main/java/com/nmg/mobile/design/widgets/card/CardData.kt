package com.nmg.mobile.design.widgets.card

abstract class CardDataAbstract(
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    private val _timecode: String? = null,
) : CardDisplayable, TimecodeDisplayable {
    override val timecode: String
        get() = _timecode ?: "--:--"
}

data class CardData(
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    val _timecode: String? = null,
) : CardDataAbstract(
    imageURL = imageURL,
    headline = headline,
    leadingFootnote = leadingFootnote,
    secondFootnote = secondFootnote,
    _timecode = _timecode,
)