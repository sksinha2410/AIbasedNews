package com.ainews.app.data

/**
 * Mock data source providing health news articles for the app.
 * In a production app, this would be replaced with RSS feed parsing or API calls.
 */
object MockNewsDataSource {

    fun getMockArticles(): List<NewsArticle> = listOf(
        NewsArticle(
            id = "1",
            title = "New Study Reveals Benefits of Mediterranean Diet for Heart Health",
            content = """A comprehensive study published in the Journal of the American Medical Association has found that following a Mediterranean diet can significantly reduce the risk of cardiovascular disease. The research, which followed over 25,000 participants for 12 years, showed that those who adhered closely to the diet had a 30% lower risk of heart attacks and strokes compared to those who didn't follow the diet.

The Mediterranean diet emphasizes consumption of fruits, vegetables, whole grains, legumes, nuts, and olive oil, while limiting red meat and processed foods. The study also found that participants who combined the diet with regular physical activity saw even greater benefits, with some showing a 45% reduction in cardiovascular events.

Dr. Sarah Johnson, the lead researcher, noted that the diet's emphasis on healthy fats from olive oil and fish, combined with its high fiber content from whole grains and vegetables, creates a powerful combination for heart health. The study also observed improvements in cholesterol levels and blood pressure among participants following the diet.

Experts recommend gradually transitioning to a Mediterranean-style eating pattern rather than making sudden drastic changes. Starting with simple swaps like using olive oil instead of butter and adding more vegetables to meals can be an effective first step.""",
            source = "Health Daily",
            publishedDate = "2024-01-15",
            imageUrl = "https://picsum.photos/seed/med-diet/400/200",
            category = "Nutrition"
        ),
        NewsArticle(
            id = "2",
            title = "Breaking: New Mental Health Guidelines Emphasize Sleep Importance",
            content = """The World Health Organization has released updated mental health guidelines that place unprecedented emphasis on the importance of sleep for psychological well-being. The new recommendations suggest that adults should aim for 7-9 hours of quality sleep per night, citing compelling research linking sleep deprivation to anxiety, depression, and cognitive decline.

The guidelines highlight that chronic sleep deprivation can lead to a 40% increase in the risk of developing depression and anxiety disorders. Additionally, poor sleep quality has been associated with increased levels of stress hormones and inflammation markers in the body, both of which can negatively impact mental health.

Dr. Michael Chen, a sleep specialist who contributed to the guidelines, explained that during sleep, the brain processes emotions and consolidates memories. When this process is disrupted, individuals may experience difficulty regulating their emotions and increased vulnerability to mental health challenges.

The WHO recommends establishing a consistent sleep schedule, creating a dark and quiet sleeping environment, and avoiding screens for at least one hour before bedtime. For those struggling with sleep issues, cognitive behavioral therapy for insomnia (CBT-I) is recommended as a first-line treatment before considering medication.""",
            source = "WHO News",
            publishedDate = "2024-01-14",
            imageUrl = "https://picsum.photos/seed/sleep/400/200",
            category = "Mental Health"
        ),
        NewsArticle(
            id = "3",
            title = "Exercise Found to Be as Effective as Medication for Mild Depression",
            content = """A landmark meta-analysis combining data from 41 studies has concluded that regular exercise can be as effective as antidepressant medication for treating mild to moderate depression. The research, published in the British Journal of Sports Medicine, analyzed data from over 2,000 participants and found that consistent physical activity led to significant improvements in depressive symptoms.

The studies examined various types of exercise, including aerobic activities like running and swimming, as well as strength training and yoga. Researchers found that all forms of exercise showed benefits, with aerobic exercise demonstrating the most consistent positive effects on mood.

According to the analysis, exercising for 30-45 minutes, three to five times per week, produced optimal results. The benefits were observed within just four weeks of starting a regular exercise routine, though sustained improvement required continued physical activity.

Dr. Emma Williams, the study's lead author, emphasized that exercise should not replace medication for those with severe depression or those already on a treatment plan. However, for individuals with mild symptoms, exercise may be considered as a first-line treatment option. The mechanism appears to involve the release of endorphins, increased production of brain-derived neurotrophic factor, and improved sleep quality.""",
            source = "Medical Research Today",
            publishedDate = "2024-01-13",
            imageUrl = "https://picsum.photos/seed/exercise/400/200",
            category = "Fitness"
        ),
        NewsArticle(
            id = "4",
            title = "Scientists Discover Link Between Gut Health and Immune Function",
            content = """Groundbreaking research from Stanford University has revealed a strong connection between gut microbiome diversity and immune system function. The study found that individuals with a more diverse gut microbiome showed significantly stronger immune responses to vaccines and infections compared to those with less diverse gut bacteria.

The research team analyzed stool samples and immune markers from 500 participants over two years. They discovered that certain beneficial bacteria, particularly those from the Bifidobacterium and Lactobacillus families, were associated with higher levels of antibody production and more efficient immune cell function.

Interestingly, the study also found that diet played a crucial role in maintaining gut microbiome diversity. Participants who consumed a diet rich in fiber from various sources - including fruits, vegetables, legumes, and whole grains - had more diverse gut bacteria compared to those eating processed foods.

Dr. Lisa Park, the principal investigator, suggests that eating a variety of plant-based foods can help nurture a healthy gut microbiome. The research also highlighted the potential negative impact of frequent antibiotic use on gut bacteria diversity, though necessary antibiotic treatments should not be avoided. Probiotic supplements showed modest benefits in the study, but whole foods remained the most effective way to support gut health.""",
            source = "Science Health Journal",
            publishedDate = "2024-01-12",
            imageUrl = "https://picsum.photos/seed/gut/400/200",
            category = "Research"
        ),
        NewsArticle(
            id = "5",
            title = "Walking 10,000 Steps: New Research Questions Popular Health Target",
            content = """A new study challenges the widely popular goal of walking 10,000 steps daily, suggesting that significant health benefits can be achieved with far fewer steps. Research published in The Lancet followed 78,000 participants and found that health benefits begin at just 2,500 steps per day, with the most substantial improvements occurring between 4,000 and 8,000 steps.

The 10,000-step target originated from a 1960s Japanese marketing campaign for a pedometer and was not based on scientific evidence. While walking 10,000 steps remains beneficial, the new research shows that it may not be necessary for everyone to achieve meaningful health improvements.

For older adults and those with mobility limitations, the study found that 4,400 steps per day reduced mortality risk by 40% compared to walking only 2,700 steps. Importantly, intensity matters too - brisk walking provides greater cardiovascular benefits than slow-paced walking, even with the same step count.

Dr. Robert Hughes, a cardiovascular researcher, advises that people should focus on increasing their current activity level rather than fixating on a specific number. For sedentary individuals, adding just 2,000 steps to their daily routine can lead to measurable health improvements including better blood sugar control, improved mood, and reduced risk of chronic disease.""",
            source = "The Lancet Health",
            publishedDate = "2024-01-11",
            imageUrl = "https://picsum.photos/seed/walking/400/200",
            category = "Fitness"
        ),
        NewsArticle(
            id = "6",
            title = "Vitamin D Deficiency Linked to Increased COVID-19 Severity",
            content = """Multiple studies have now confirmed a strong association between vitamin D deficiency and more severe COVID-19 outcomes. A comprehensive review of 54 studies involving over 1.8 million participants found that those with adequate vitamin D levels had significantly lower rates of hospitalization and mortality from COVID-19.

The research suggests that vitamin D plays a crucial role in modulating the immune system's response to viral infections. Low vitamin D levels were associated with increased inflammatory responses, which can lead to the dangerous cytokine storms seen in severe COVID-19 cases.

Health experts recommend maintaining vitamin D levels between 30-50 ng/mL for optimal immune function. This can be achieved through a combination of sun exposure, dietary sources like fatty fish and fortified foods, and supplementation when necessary. However, experts caution against excessive supplementation, as very high vitamin D levels can cause toxicity.

Dr. Amanda Torres, an immunologist, notes that while vitamin D supplementation should not be considered a treatment or prevention for COVID-19, maintaining adequate levels as part of overall health may support better outcomes. She recommends that individuals, especially those in northern climates or with limited sun exposure, have their vitamin D levels tested and discuss supplementation with their healthcare provider.""",
            source = "Immunology Weekly",
            publishedDate = "2024-01-10",
            imageUrl = "https://picsum.photos/seed/vitamind/400/200",
            category = "Immune Health"
        ),
        NewsArticle(
            id = "7",
            title = "Intermittent Fasting Shows Promise for Blood Sugar Control",
            content = """A clinical trial conducted by Johns Hopkins University has demonstrated that intermittent fasting can significantly improve blood sugar control in people with prediabetes. The study followed 150 participants over 12 weeks and found that those practicing time-restricted eating showed marked improvements in insulin sensitivity and fasting glucose levels.

Participants in the study followed a 16:8 eating pattern, consuming all their meals within an 8-hour window and fasting for the remaining 16 hours. By the end of the trial, 90% of participants saw improvements in their blood sugar levels, with 30% no longer meeting the criteria for prediabetes.

The research team observed that the timing of the eating window mattered. Participants who ate earlier in the day (8 AM to 4 PM) showed better results than those who ate later (noon to 8 PM), suggesting that aligning eating patterns with the body's circadian rhythm may enhance the benefits.

Dr. David Kim, the study's lead researcher, cautions that intermittent fasting is not appropriate for everyone, particularly those with diabetes who are on medication, pregnant women, or individuals with a history of eating disorders. He recommends consulting with a healthcare provider before starting any fasting regimen and emphasizes that the quality of food consumed during eating windows remains important for overall health.""",
            source = "Diabetes Research News",
            publishedDate = "2024-01-09",
            imageUrl = "https://picsum.photos/seed/fasting/400/200",
            category = "Nutrition"
        ),
        NewsArticle(
            id = "8",
            title = "Mindfulness Meditation Reduces Chronic Pain, Study Confirms",
            content = """A randomized controlled trial published in JAMA Internal Medicine has provided strong evidence that mindfulness meditation can effectively reduce chronic pain. The study, which included 520 participants with various chronic pain conditions, found that an 8-week mindfulness program reduced pain intensity by an average of 30% and improved quality of life scores significantly.

The mindfulness program taught participants to observe their pain sensations without judgment and to develop a different relationship with their discomfort. Rather than trying to eliminate pain, participants learned to reduce the emotional suffering associated with chronic pain.

Brain imaging studies conducted as part of the research revealed that regular meditation practice led to changes in brain regions associated with pain processing and emotional regulation. Participants who meditated showed reduced activity in the brain's pain matrix and increased activity in areas associated with pain modulation.

Dr. Jennifer Walsh, a pain specialist, explains that while mindfulness meditation doesn't eliminate the physical sensation of pain, it can significantly reduce the psychological distress and suffering that often accompanies chronic pain. The study found that benefits were maintained at a 6-month follow-up, suggesting that the skills learned through meditation have lasting effects. For those interested in trying mindfulness for pain management, apps and guided meditation programs can provide an accessible starting point.""",
            source = "Pain Management Today",
            publishedDate = "2024-01-08",
            imageUrl = "https://picsum.photos/seed/meditation/400/200",
            category = "Mental Health"
        ),
        NewsArticle(
            id = "9",
            title = "Green Spaces in Cities Linked to Better Mental Health Outcomes",
            content = """Urban planning research has established a clear connection between access to green spaces and improved mental health among city dwellers. A study spanning 10 major cities across 4 continents found that residents living within 300 meters of parks or green areas reported 25% lower rates of depression and anxiety compared to those without nearby nature access.

The research team used satellite imagery to measure green space coverage and cross-referenced this data with mental health surveys and medical records. They controlled for factors such as income, age, and pre-existing health conditions to isolate the effect of green space access.

The benefits appeared to be dose-dependent - more frequent visits to green spaces correlated with greater mental health improvements. Even brief exposure to nature, such as a 20-minute walk in a park, was associated with reduced cortisol levels and improved mood.

Dr. Rachel Green, an environmental health researcher, suggests that cities should prioritize the creation and maintenance of accessible green spaces as a public health investment. The study also found that the quality of green spaces matters, with well-maintained parks providing greater benefits than neglected areas. For individuals without easy access to parks, the research suggests that indoor plants and window views of nature can provide some, though lesser, mental health benefits.""",
            source = "Urban Health Review",
            publishedDate = "2024-01-07",
            imageUrl = "https://picsum.photos/seed/greenspace/400/200",
            category = "Mental Health"
        ),
        NewsArticle(
            id = "10",
            title = "New Antibiotic Discovered in Human Nose Shows Promise Against MRSA",
            content = """Scientists at the University of Tubingen have discovered a new antibiotic compound produced by bacteria living in the human nose that shows remarkable effectiveness against drug-resistant MRSA infections. The compound, named Lugdunin, represents the first antibiotic discovered in the human microbiome with potential clinical applications.

The discovery came from studying why some people are naturally resistant to Staphylococcus aureus colonization while others are susceptible. Researchers found that individuals carrying the bacterium Staphylococcus lugdunensis in their nasal passages were six times less likely to carry S. aureus, including MRSA strains.

Laboratory tests demonstrated that Lugdunin could kill MRSA bacteria at concentrations safe for human cells. Moreover, in animal studies, the compound successfully treated skin infections caused by MRSA without observable side effects. Importantly, bacteria did not develop resistance to Lugdunin even after extended exposure.

Dr. Martin Hofer, lead researcher, explains that Lugdunin works through a novel mechanism that disrupts bacterial energy production, making it difficult for bacteria to develop resistance. While human trials are still years away, this discovery opens new avenues for antibiotic development and highlights the potential of the human microbiome as a source for new medicines. The finding also suggests that probiotic approaches might one day help prevent antibiotic-resistant infections.""",
            source = "Microbiology Frontiers",
            publishedDate = "2024-01-06",
            imageUrl = "https://picsum.photos/seed/antibiotic/400/200",
            category = "Research"
        ),
        NewsArticle(
            id = "11",
            title = "Screen Time Before Bed Disrupts Children's Sleep Patterns",
            content = """A comprehensive study of 5,000 children ages 6-17 has confirmed that screen time in the two hours before bedtime significantly disrupts sleep quality and duration. The research found that children who used electronic devices before bed took longer to fall asleep, experienced more nighttime awakenings, and got an average of 45 minutes less sleep per night.

The study, conducted by the National Sleep Foundation, measured screen time using app tracking software and monitored sleep patterns using wearable devices. Researchers found that the blue light emitted by screens suppresses melatonin production, the hormone responsible for regulating sleep-wake cycles.

Beyond blue light effects, the stimulating content of many apps and games was found to increase mental arousal, making it harder for children's brains to wind down for sleep. Social media use before bed was particularly problematic, often triggering emotional responses that interfered with relaxation.

Dr. Paula Martinez, a pediatric sleep specialist, recommends establishing a "digital sunset" one to two hours before bedtime. During this time, families can engage in calming activities such as reading physical books, taking baths, or practicing relaxation exercises. For families where evening screen use is unavoidable, using night mode settings that reduce blue light can help minimize, though not eliminate, the impact on sleep.""",
            source = "Pediatric Health News",
            publishedDate = "2024-01-05",
            imageUrl = "https://picsum.photos/seed/screentime/400/200",
            category = "Sleep"
        ),
        NewsArticle(
            id = "12",
            title = "Plant-Based Proteins Found Equally Effective for Muscle Building",
            content = """A study published in Sports Medicine has found that plant-based proteins can be just as effective as animal proteins for building and maintaining muscle mass, provided protein intake is adequate. The research compared muscle protein synthesis rates in athletes consuming either animal or plant-based protein sources and found no significant differences when protein quantity and quality were matched.

The study followed 120 athletes over 12 weeks, with half consuming primarily animal proteins and half consuming plant-based alternatives. Both groups achieved similar gains in muscle mass and strength, challenging the long-held belief that animal proteins are superior for muscle building.

Key to success with plant-based proteins was consuming a variety of sources to ensure all essential amino acids were obtained. The research highlighted that combining different plant proteins - such as legumes with grains - creates a complete amino acid profile comparable to animal sources.

Dr. Chris Foster, a sports nutritionist, notes that plant-based athletes may need to consume slightly more total protein to account for the generally lower digestibility of plant proteins. He recommends plant-based athletes aim for 1.8-2.0 grams of protein per kilogram of body weight, compared to the 1.6-1.8 grams typically recommended for those eating animal proteins. Popular plant protein sources include soy, peas, hemp, lentils, and combinations of rice and beans.""",
            source = "Sports Science Weekly",
            publishedDate = "2024-01-04",
            imageUrl = "https://picsum.photos/seed/plantprotein/400/200",
            category = "Nutrition"
        )
    )
}
