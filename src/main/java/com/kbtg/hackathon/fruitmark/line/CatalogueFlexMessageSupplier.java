package com.kbtg.hackathon.fruitmark.line;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.Button;
import com.linecorp.bot.model.message.flex.component.FlexComponent;
import com.linecorp.bot.model.message.flex.component.Image;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.container.Carousel;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

public class CatalogueFlexMessageSupplier implements Supplier<FlexMessage> {
	
	@Override
	public FlexMessage get() {
		final Bubble bubble1 = createBubble("เงาะโรงเรียนสาธิต", "199.00", "https://cdn-images-1.medium.com/max/800/1*j_GNGNFeZbg7GSzmyNWvEA.jpeg");
		final Bubble bubble2 = createBubble("เงาะโรงเรียนวัด", "19.00", "https://2553d2b9.ngrok.io/img/bubble2.png");
		final Carousel carousel = Carousel.builder().contents(asList(bubble1, bubble2)).build();
		return new FlexMessage("เลือกซื้อสินค้า", carousel);
	}
	
	private Bubble createBubble(String title, String price, String imageURL) {
		final Image heroBlock = createHeroBlock(imageURL);
		final Box bodyBlock = createBodyBlock(title, price);
		final Box footerBlock = createFooterBlock();
		return Bubble.builder().hero(heroBlock).body(bodyBlock).footer(footerBlock).build();
	}
	
	private Image createHeroBlock(String imageURL) {
		return Image.builder().size(Image.ImageSize.FULL_WIDTH).aspectRatio(Image.ImageAspectRatio.R20TO13).aspectMode(Image.ImageAspectMode.Cover).url(imageURL).build();
	}
	
	private Box createBodyBlock(String title, String price) {
		final Text titleBlock = Text.builder().text(title).wrap(true).weight(Text.TextWeight.BOLD).size(FlexFontSize.XL).build();
		final Box priceBlock = Box.builder().layout(FlexLayout.BASELINE)
		    .contents(asList(Text.builder().text("฿ " + price.split("\\.")[0]).wrap(true).weight(Text.TextWeight.BOLD).size(FlexFontSize.XL).flex(0).build(),
		        Text.builder().text("." + price.split("\\.")[1]).wrap(true).weight(Text.TextWeight.BOLD).size(FlexFontSize.SM).flex(0).build()))
		    .build();
		
		FlexComponent[] flexComponents = { titleBlock, priceBlock };
		List<FlexComponent> listComponent = new ArrayList<>(Arrays.asList(flexComponents));
		
		return Box.builder().layout(FlexLayout.VERTICAL).spacing(FlexMarginSize.SM).contents(listComponent).build();
	}
	
	private Box createFooterBlock() {
		final Button addToCartEnableButton = Button.builder().style(Button.ButtonStyle.PRIMARY).action(new URIAction("Add to Cart", "http://example.com")).build();
		return Box.builder().layout(FlexLayout.VERTICAL).spacing(FlexMarginSize.SM).contents(asList(addToCartEnableButton)).build();
	}
	
}