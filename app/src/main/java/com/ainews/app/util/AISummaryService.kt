package com.ainews.app.util

import com.ainews.app.data.NewsArticle
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * AI Summary Service that generates TL;DR summaries, key takeaways,
 * and simplified versions of health news articles.
 * 
 * In a production app, this would integrate with an actual AI API (e.g., OpenAI, Claude).
 * For this demo, we use deterministic summarization algorithms.
 */
object AISummaryService {
    
    /**
     * Configuration flag to enable/disable simulated delays.
     * Set to false in production or for testing to skip artificial delays.
     */
    var simulateDelays: Boolean = true
    
    /**
     * Generates a TL;DR summary and key takeaways for an article.
     * Simulates AI processing with a delay when simulateDelays is true.
     */
    suspend fun generateSummary(article: NewsArticle): NewsArticle {
        if (simulateDelays) {
            // Simulate AI processing time (300-800ms)
            delay(Random.nextLong(300, 800))
        }
        
        return article.copy(
            tldr = generateTldr(article),
            keyTakeaways = generateKeyTakeaways(article)
        )
    }
    
    /**
     * Regenerates the summary for an article.
     */
    suspend fun regenerateSummary(article: NewsArticle): NewsArticle {
        if (simulateDelays) {
            // Simulate regeneration with slightly longer delay
            delay(Random.nextLong(400, 900))
        }
        
        return article.copy(
            tldr = generateTldr(article),
            keyTakeaways = generateKeyTakeaways(article)
        )
    }
    
    /**
     * Generates a simplified, friendly version of the article content.
     */
    suspend fun generateSimplifiedContent(article: NewsArticle): NewsArticle {
        if (simulateDelays) {
            // Simulate AI simplification processing
            delay(Random.nextLong(500, 1000))
        }
        
        return article.copy(
            simplifiedContent = simplifyContent(article)
        )
    }
    
    /**
     * Generates a 2-line TL;DR summary from the article.
     */
    private fun generateTldr(article: NewsArticle): String {
        return when (article.id) {
            "1" -> "A 12-year study of 25,000 people shows the Mediterranean diet reduces heart disease risk by 30%. Combined with exercise, protection increases to 45%."
            "2" -> "WHO's new guidelines emphasize 7-9 hours of sleep for mental health. Poor sleep increases depression and anxiety risk by 40%."
            "3" -> "Research confirms exercise can match antidepressants for mild depression. Just 30-45 minutes of activity, 3-5 times weekly, shows results in 4 weeks."
            "4" -> "Stanford study reveals gut bacteria diversity strengthens immunity. A varied plant-based diet is key to maintaining healthy gut microbiome."
            "5" -> "New research debunks the 10,000-step myth. Health benefits begin at just 2,500 steps, with optimal gains between 4,000-8,000 daily steps."
            "6" -> "Multiple studies confirm vitamin D deficiency worsens COVID-19 outcomes. Maintaining levels of 30-50 ng/mL supports better immune function."
            "7" -> "Johns Hopkins trial shows 16:8 intermittent fasting improves blood sugar in prediabetics. Earlier eating windows (8AM-4PM) work best."
            "8" -> "JAMA study proves 8 weeks of mindfulness meditation reduces chronic pain by 30%. Benefits include changed brain activity and lasting effects."
            "9" -> "City residents near green spaces have 25% lower depression rates. Even 20-minute park visits reduce stress hormones significantly."
            "10" -> "New antibiotic from human nose bacteria kills MRSA without resistance. This could be a breakthrough against drug-resistant infections."
            "11" -> "Screen time before bed cuts children's sleep by 45 minutes nightly. Blue light and stimulating content both disrupt sleep quality."
            "12" -> "Plant proteins match animal proteins for muscle building when eaten adequately. Combining sources like beans and grains provides complete nutrition."
            else -> extractFirstTwoSentences(article.content)
        }
    }
    
    /**
     * Generates 3 key takeaways from the article.
     */
    private fun generateKeyTakeaways(article: NewsArticle): List<String> {
        return when (article.id) {
            "1" -> listOf(
                "Mediterranean diet cuts cardiovascular risk by 30% over 12 years",
                "Adding exercise boosts protection to 45% reduction in heart events",
                "Start simple: swap butter for olive oil and add more vegetables"
            )
            "2" -> listOf(
                "Aim for 7-9 hours of quality sleep every night",
                "Sleep deprivation increases depression risk by 40%",
                "Create a dark, quiet room and avoid screens before bed"
            )
            "3" -> listOf(
                "Exercise can be as effective as medication for mild depression",
                "30-45 minutes of activity, 3-5 times per week is optimal",
                "Benefits appear within just 4 weeks of starting exercise"
            )
            "4" -> listOf(
                "Diverse gut bacteria = stronger immune response to vaccines",
                "Eat a variety of fiber-rich plants for best gut health",
                "Frequent antibiotic use can reduce gut bacteria diversity"
            )
            "5" -> listOf(
                "Health benefits start at just 2,500 daily steps",
                "Optimal benefits occur between 4,000-8,000 steps",
                "Brisk walking provides more benefit than slow walking"
            )
            "6" -> listOf(
                "Vitamin D levels of 30-50 ng/mL support immune function",
                "Deficiency linked to worse COVID-19 outcomes",
                "Get vitamin D from sun, fatty fish, or supplements if needed"
            )
            "7" -> listOf(
                "16:8 fasting (eat in 8-hour window) improves blood sugar",
                "Earlier eating times (8AM-4PM) show better results",
                "30% of prediabetics reversed their condition in the study"
            )
            "8" -> listOf(
                "8 weeks of mindfulness reduces chronic pain by 30%",
                "Meditation changes brain regions that process pain",
                "Benefits last at least 6 months after learning techniques"
            )
            "9" -> listOf(
                "Living near parks reduces depression by 25%",
                "Even 20-minute nature walks lower stress hormones",
                "Indoor plants can provide some mental health benefits"
            )
            "10" -> listOf(
                "Nose bacteria produces antibiotic effective against MRSA",
                "Bacteria don't develop resistance to this new compound",
                "Human microbiome may be source for new medicines"
            )
            "11" -> listOf(
                "Screens before bed cost children 45 minutes of sleep",
                "Blue light suppresses melatonin, the sleep hormone",
                "Create a 'digital sunset' 1-2 hours before bedtime"
            )
            "12" -> listOf(
                "Plant and animal proteins build muscle equally well",
                "Combine different plant sources for complete amino acids",
                "Plant-based athletes may need slightly more total protein"
            )
            else -> extractKeyTakeawaysGeneric(article.content)
        }
    }
    
    /**
     * Simplifies article content into a friendly, easy-to-understand format.
     */
    private fun simplifyContent(article: NewsArticle): String {
        return when (article.id) {
            "1" -> """
🥗 **What's the Mediterranean Diet?**
Think of it as eating like people who live by the Mediterranean Sea - lots of colorful fruits and veggies, whole grains, nuts, and olive oil. Less red meat and processed stuff.

💪 **Why It's Great for Your Heart**
Scientists followed 25,000 people for 12 years (that's a really long time!). People who ate this way had 30% fewer heart attacks and strokes. Add some exercise, and that jumps to 45% fewer heart problems!

🫒 **The Secret Ingredients**
The healthy fats from olive oil and fish, plus all the fiber from veggies and grains, team up to keep your heart happy. People on this diet also saw their cholesterol and blood pressure improve.

🚀 **How to Start**
Don't stress about changing everything overnight! Try these easy swaps:
- Use olive oil instead of butter
- Add an extra serving of vegetables to dinner
- Snack on nuts instead of chips
- Grill fish once or twice a week

Small changes add up to big heart health benefits! 💚
            """.trimIndent()
            
            "2" -> """
😴 **Sleep Is Seriously Important**
The World Health Organization just released new guidelines, and they're really clear: sleep isn't optional for good mental health!

📊 **The Numbers Don't Lie**
Adults need 7-9 hours of quality sleep each night. If you're not getting enough, you're 40% more likely to develop depression or anxiety. That's almost half!

🧠 **What Happens When You Sleep**
Your brain is actually super busy while you snooze - it's processing your emotions and storing memories. Skip sleep, and your brain can't do its important maintenance work.

💤 **Better Sleep Tips**
- Go to bed and wake up at the same times (yes, even on weekends!)
- Make your room dark like a cave and quiet like a library
- Put away phones and tablets an hour before bed
- If you struggle with sleep, try CBT-I (a special kind of therapy) before reaching for pills

Sweet dreams lead to happier days! 🌙
            """.trimIndent()
            
            "3" -> """
🏃 **Exercise = Happy Brain**
Big news: moving your body can work as well as antidepressants for mild depression! Scientists combined data from 41 studies and over 2,000 people to figure this out.

💊 **How It Compares to Medication**
For mild to moderate depression, regular exercise showed similar improvements to taking antidepressant pills. That's pretty amazing!

⏱️ **The Magic Formula**
- Exercise 30-45 minutes at a time
- Do it 3-5 times per week
- You'll start feeling better in just 4 weeks!
- Running, swimming, strength training, yoga - they all work

🎯 **Important Notes**
- This is for MILD depression - please keep taking medication if your doctor prescribed it for severe depression
- The "happy chemicals" (endorphins) your body releases during exercise naturally boost your mood
- Better sleep and feeling accomplished also help!

Your sneakers might be the best medicine in your closet! 👟
            """.trimIndent()
            
            "4" -> """
🦠 **Your Gut Is Like a Garden**
Inside your belly lives trillions of tiny bacteria - and the more variety you have, the better! Stanford scientists discovered that people with diverse gut bacteria have stronger immune systems.

🛡️ **The Immunity Connection**
People with lots of different good bacteria:
- Respond better to vaccines
- Fight off infections more effectively
- Produce more antibodies (your body's little soldiers)

🥦 **How to Feed Your Good Bacteria**
Your gut buddies love fiber! Feed them with:
- Fruits and vegetables (lots of different colors!)
- Beans and lentils
- Whole grains
- Different types of foods, not the same thing every day

⚠️ **What Hurts Your Gut Garden**
- Processed foods are like junk food for bacteria
- Taking antibiotics often can wipe out good bacteria (but still take them when you really need them!)
- Probiotics (pills) help a little, but real food works better

A happy gut = a strong immune system! 🌱
            """.trimIndent()
            
            "5" -> """
👟 **10,000 Steps? Not So Fast!**
Here's a fun fact: that 10,000-step goal came from a Japanese pedometer ad in the 1960s, not from science! New research says you don't need that many steps to be healthier.

📈 **What the Science Actually Says**
Scientists tracked 78,000 people and found:
- Health benefits start at just 2,500 steps!
- The sweet spot is 4,000-8,000 steps daily
- For older adults, 4,400 steps cut death risk by 40%

⚡ **Speed Matters Too**
Walking fast (like you're late for something) is better for your heart than strolling slowly, even if you take the same number of steps.

🎯 **What to Do**
- Don't stress about hitting exactly 10,000 steps
- Just try to add more movement than yesterday
- If you sit a lot, adding even 2,000 extra steps helps!
- Focus on walking briskly when you can

Every step counts, but you don't need to count every step! 🚶
            """.trimIndent()
            
            "6" -> """
☀️ **The Sunshine Vitamin and COVID**
Multiple studies now show that having enough vitamin D in your body is linked to less severe COVID-19 infections. It's not a cure, but it seems to help!

📊 **What the Research Found**
Scientists looked at data from 1.8 million people:
- People with good vitamin D levels had fewer hospitalizations
- They also had lower death rates from COVID-19
- Low vitamin D = more inflammation (and that's bad news)

🎯 **How Much Do You Need?**
Aim for vitamin D levels between 30-50 ng/mL. You can get it from:
- Sunshine (15-20 minutes a few times a week)
- Fatty fish like salmon
- Foods with added vitamin D (milk, cereals)
- Supplements if your doctor recommends them

⚠️ **Important Warnings**
- Vitamin D is NOT a treatment for COVID-19
- Don't take too much - that can be harmful!
- Get your levels tested, especially if you live somewhere without much sun
- Talk to your doctor before starting supplements

Keep your vitamin D levels healthy - your immune system will thank you! 🌞
            """.trimIndent()
            
            "7" -> """
⏰ **What's Intermittent Fasting?**
It's not about WHAT you eat, but WHEN. The most popular method is 16:8 - you eat all your food within 8 hours and fast (no food) for 16 hours.

🩸 **Great News for Blood Sugar**
Johns Hopkins studied 150 people with prediabetes:
- 90% saw their blood sugar improve
- 30% were no longer prediabetic after just 12 weeks!
- Insulin (the hormone that controls blood sugar) worked better

🌅 **Timing Is Everything**
Here's a surprise - eating EARLIER works better:
- Best results: Eat between 8 AM and 4 PM
- Not as good: Eating noon to 8 PM
- Your body likes food when the sun is up!

⚠️ **Who Should NOT Try This**
- People with diabetes taking medication (can be dangerous!)
- Pregnant women
- Anyone with a history of eating disorders
- Kids and teenagers

Always check with your doctor before changing how you eat! 🏥
            """.trimIndent()
            
            "8" -> """
🧘 **Meditation for Pain Relief**
A big study (520 people!) found that mindfulness meditation can reduce chronic pain by 30%. It's not magic - it's science!

🧠 **How Does It Work?**
When you meditate regularly:
- Your brain actually changes (yes, really!)
- The parts that process pain become less active
- The parts that control emotions get stronger
- You learn to observe pain without freaking out about it

📅 **The 8-Week Program**
Study participants:
- Practiced mindfulness for 8 weeks
- Learned to notice pain without judging it
- Developed a different relationship with discomfort
- Still felt pain, but suffered less emotionally

✨ **The Best Part**
The benefits lasted at least 6 months after the program ended! Once you learn these skills, you keep them.

🎯 **Getting Started**
- You don't need anything fancy
- Apps like Headspace or Calm can guide you
- Start with just 5-10 minutes daily
- Be patient - it takes practice!

Pain might not disappear, but suffering doesn't have to be your constant companion 🙏
            """.trimIndent()
            
            "9" -> """
🌳 **Nature Is Medicine**
Living near parks and green spaces isn't just nice - it's actually good for your mental health! A huge study across 10 cities proved it.

📊 **The Amazing Numbers**
People living within 300 meters of green spaces:
- Had 25% lower rates of depression
- Had 25% lower rates of anxiety
- The more you visit nature, the better you feel!

🧪 **The Science Behind It**
Just 20 minutes in a park:
- Lowers cortisol (your stress hormone)
- Improves your mood
- Helps your brain relax and recharge

🏙️ **No Park Nearby?**
Don't worry, you have options:
- Indoor plants provide some benefits
- Even looking at nature through a window helps
- Pictures or videos of nature have some effect too
- Take the scenic route when walking somewhere

🌱 **For City Planners**
The study suggests cities should invest in parks as a public health strategy. More green = happier, healthier residents!

Get outside when you can - your brain will thank you! 🌿
            """.trimIndent()
            
            "10" -> """
👃 **An Antibiotic From Your Nose?!**
Scientists made an incredible discovery: bacteria living in some people's noses produce a natural antibiotic that can kill dangerous MRSA superbugs!

🦠 **Why This Matters**
MRSA is a "superbug" - regular antibiotics don't work against it. But this new compound called Lugdunin does work, and here's the exciting part: bacteria CAN'T become resistant to it!

🔬 **How They Found It**
Researchers wondered why some people never get Staph infections. Turns out, certain nose bacteria protect them by making their own antibiotic!

🎯 **What It Can Do**
In lab tests, Lugdunin:
- Killed MRSA bacteria completely
- Didn't harm human cells
- Worked on skin infections in animals
- Bacteria couldn't develop resistance to it

⏳ **What's Next**
- Human trials are still years away
- But this opens up exciting new possibilities
- Your own body might be a pharmacy we haven't explored yet!

Our bodies are more amazing than we knew! 🔬
            """.trimIndent()
            
            "11" -> """
📱 **Screens and Sleep Don't Mix**
A study of 5,000 kids (ages 6-17) confirms what parents suspected: using devices before bed seriously messes with sleep!

😴 **The Sleep-Stealing Stats**
Kids who use screens before bed:
- Take longer to fall asleep
- Wake up more during the night
- Get 45 minutes LESS sleep each night
- That adds up to over 5 hours per week!

🔵 **Why Blue Light Is Bad**
Screens give off blue light that:
- Tells your brain "it's daytime!"
- Stops your body from making melatonin (the sleep hormone)
- Keeps you alert when you should be winding down

🎮 **It's Not Just the Light**
Exciting games and social media:
- Get your brain all hyped up
- Make it hard to calm down
- Trigger emotions that keep you awake

✨ **The Solution: Digital Sunset**
1-2 hours before bed:
- Put away all screens
- Read a physical book instead
- Take a bath
- Do calming activities as a family
- If screens are unavoidable, use "night mode"

Better sleep = better everything! 🌙
            """.trimIndent()
            
            "12" -> """
💪 **Plants Can Build Muscle Too!**
Great news for vegetarians and vegans: plant proteins work just as well as meat for building muscle! Scientists studied athletes for 12 weeks and proved it.

🥩 vs 🌱 **The Showdown**
- 60 athletes ate mostly animal protein
- 60 athletes ate mostly plant protein
- Result: BOTH groups gained the same amount of muscle!

🔑 **The Key to Plant Protein Success**
Plants don't have all the building blocks (amino acids) in one food, so you need to:
- Eat a variety of protein sources
- Combine foods like beans + rice, or hummus + pita
- Think "complementary proteins"

📊 **How Much Do You Need?**
- Animal-based athletes: 1.6-1.8g protein per kg body weight
- Plant-based athletes: 1.8-2.0g per kg (slightly more)
- Why more? Plant proteins are a bit harder to digest

🌿 **Best Plant Protein Sources**
- Soy (tofu, tempeh, edamame)
- Lentils and beans
- Quinoa
- Hemp seeds
- Pea protein powder

You don't need meat to be strong! 🌱💪
            """.trimIndent()
            
            else -> generateGenericSimplification(article)
        }
    }
    
    /**
     * Extracts first two sentences for generic TL;DR.
     */
    private fun extractFirstTwoSentences(content: String): String {
        val sentences = content.split(Regex("[.!?]\\s+"))
            .filter { it.isNotBlank() }
            .take(2)
        return sentences.joinToString(". ").trim() + "."
    }
    
    /**
     * Generates generic key takeaways from content.
     */
    private fun extractKeyTakeawaysGeneric(content: String): List<String> {
        val sentences = content.split(Regex("[.!?]\\s+"))
            .filter { it.length in 20..150 }
            .take(3)
        return sentences.map { it.trim() + "." }
    }
    
    /**
     * Generates a generic simplified version.
     */
    private fun generateGenericSimplification(article: NewsArticle): String {
        return """
**📰 ${article.title}**

${article.content.take(500)}...

💡 **The Bottom Line**
${article.tldr}

🎯 **Remember These Points**
${article.keyTakeaways.mapIndexed { index, takeaway -> "- $takeaway" }.joinToString("\n")}

Stay informed, stay healthy! 💚
        """.trimIndent()
    }
}
