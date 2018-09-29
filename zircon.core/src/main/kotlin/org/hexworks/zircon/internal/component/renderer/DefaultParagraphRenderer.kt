package org.hexworks.zircon.internal.component.renderer

import org.hexworks.zircon.api.builder.graphics.CharacterTileStringBuilder
import org.hexworks.zircon.api.component.Label
import org.hexworks.zircon.api.component.Paragraph
import org.hexworks.zircon.api.component.renderer.ComponentRenderContext
import org.hexworks.zircon.api.component.renderer.ComponentRenderer
import org.hexworks.zircon.api.graphics.SubTileGraphics
import org.hexworks.zircon.api.graphics.TextWrap

class DefaultParagraphRenderer : ComponentRenderer<Paragraph>() {

    override fun render(tileGraphics: SubTileGraphics, context: ComponentRenderContext<Paragraph>) {
        val style = context.componentStyle().getCurrentStyle()
        tileGraphics.applyStyle(style)
        CharacterTileStringBuilder.newBuilder()
                .backgroundColor(style.backgroundColor())
                .foregroundColor(style.foregroundColor())
                .modifiers(*style.modifiers().toTypedArray())
                .text(context.component.text())
                .textWrap(TextWrap.WORD_WRAP)
                .build()
                .drawOnto(tileGraphics)
    }
}