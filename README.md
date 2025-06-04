# 🎠 CarouselEffect for Jetpack Compose

A simple and flexible carousel/slider component for Jetpack Compose UI. Easily display scrollable cards or items with snapping and click support.

## ✨ Features

- 👆 Click listener with index
- 🎨 Fully customizable item content
- 🧱 Seamless integration with Compose layouts

## 📦 Installation

Using [JitPack](https://jitpack.io):

### Step 1: Add JitPack to your `settings.gradle`:
```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

implementation 'com.github.Mahnoor55:CarouselEffect:1.0.0'

val cardList = listOf(Card1, Card2, Card3, Card4, Card5, Card6)

    CarouselEffect(listSize = cardList.size, onClick = { index ->
        Toast.makeText(context, "You clicked on card $index", Toast.LENGTH_SHORT).show()
    }) { index ->
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = cardList[index]),
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Card $index",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}
▶️ [Watch the demo video](effect.mp4)

📄 License
MIT License. Feel free to use and contribute!
