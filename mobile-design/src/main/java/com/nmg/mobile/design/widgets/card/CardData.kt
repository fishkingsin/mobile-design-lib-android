package com.nmg.mobile.design.widgets.card

public abstract class CardDataProtocol(
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    override val tag: String? = null,
    private val _timecode: String? = null
) : CardDisplayable, TimecodeDisplayable {
    override val timecode: String? get() = _timecode
}

public data class CardData(
    override val imageURL: String,
    override val headline: String,
    override val leadingFootnote: String,
    override val secondFootnote: String,
    override val tag: String? = null,
    val _timecode: String? = null
) : CardDataProtocol(
    imageURL = imageURL,
    headline = headline,
    leadingFootnote = leadingFootnote,
    secondFootnote = secondFootnote,
    _timecode = _timecode
)
