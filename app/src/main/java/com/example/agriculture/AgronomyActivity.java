package com.example.agriculture;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AgronomyActivity extends AppCompatActivity {
    // Full texts for each section
    private static final String PLANTING_GUIDES_FULL = "🌱 How to Plant Successfully – Step by Step Guide for Farmers\n\n1. Soil Preparation\n- Begin by testing your soil to understand its pH and nutrients.\n- Clear the land of weeds and debris.\n- Use organic compost or manure to enrich the soil.\n- Till the soil well to allow air and roots to penetrate.\n\n2. Choosing the Right Seeds\n- Select high-quality, disease-resistant seeds suitable for your climate.\n- Buy certified seeds from trusted sources to ensure high yield.\n- Store seeds in a cool, dry place before planting.\n\n3. Land Spacing and Layout\n- Plan rows or beds with correct spacing based on the crop (e.g., maize: 75cm between rows).\n- Use string or tools to mark clear planting rows.\n- Avoid overcrowding to reduce pests and improve air circulation.\n\n4. Planting Techniques\n- Dig shallow holes of recommended depth (e.g., 2–5cm).\n- Place 1–2 seeds per hole depending on the crop.\n- Cover lightly with soil and press gently.\n\n5. Watering After Planting\n- Water the field immediately after planting.\n- Keep soil moist (not soaked) during germination period.\n- Irrigate early in the morning or late evening.\n\n6. Mulching (Optional but Helpful)\n- Apply dry grass, leaves, or husks around seedlings.\n- Mulching helps retain moisture, control weeds, and protect young plants.\n\n7. Monitoring Germination\n- Most seeds germinate within 3–14 days.\n- Check for uniform growth and fill in gaps where seeds did not sprout.\n- Start weeding early to avoid competition with crops.\n\n8. First Fertilizer Application\n- Apply starter fertilizer (if needed) about 2 weeks after planting.\n- Follow recommendations for NPK or organic alternatives.\n- Avoid putting fertilizer directly on roots.\n\n📌 Pro Tips:\n- Don’t plant during extreme heat or heavy rain.\n- Avoid using expired seeds.\n- Keep records of planting dates and varieties used.\n\n⚠️ Common Mistakes to Avoid:\n- Overcrowding crops (reduces yield)\n- Planting too deep or too shallow\n- Ignoring soil health\n- Watering at the wrong time of day\n\n🌿 Motivation:\n\"Good planting is the first step to a good harvest. Your crop’s success begins in the soil, with the right seed, and the right care.\"";
    private static final String FERTILIZATION_FULL = "🌾 Fertilization Guide – Feeding Your Crops the Right Way\n\n1. Importance of Fertilization\n- Fertilizers help replenish soil nutrients.\n- They improve plant growth and increase yield.\n- Different crops require different types and amounts.\n\n2. Types of Fertilizers\n- Organic: Compost, animal manure, green manure.\n- Inorganic (Chemical): NPK (Nitrogen, Phosphorus, Potassium).\n- Liquid fertilizers: Easily absorbed but must be well measured.\n\n3. Timing of Fertilizer Application\n- Basal application: At the time of planting (e.g., compost).\n- Top dressing: 2–4 weeks after germination.\n- Avoid over-application to prevent burning roots or harming the environment.\n\n4. How to Apply Fertilizer\n- Apply in a ring around the plant base, not directly on the stem.\n- Mix well with soil and water immediately.\n- Use protective gloves when handling chemical fertilizers.\n\n5. Soil Testing First\n- Test soil to know which nutrients are lacking.\n- Use results to guide which fertilizer to use.\n- Prevents waste and improves productivity.\n\n📌 Tip:\nOrganic fertilizers improve soil long-term. Combine with inorganic for best results.\n\n⚠️ Mistakes to Avoid:\n- Applying fertilizer too close to the stem.\n- Using too much (wastes money and harms crops).\n- Applying when soil is dry (causes root burn).\n\n🌿 Reminder:\n\"Healthy soil = Healthy crops = More income. Fertilize smart, not hard.\"";
    private static final String CROP_MANAGEMENT_FULL = "🌽 Crop Management – Keeping Your Crops Healthy\n\n1. Weed Control\n- Remove weeds early to prevent competition for nutrients and water.\n- Use hand weeding, mulching, or safe herbicides.\n\n2. Pest and Disease Management\n- Inspect crops regularly for signs of pests or diseases.\n- Use natural remedies (neem, ash) or safe pesticides.\n- Rotate crops to prevent disease buildup in soil.\n\n3. Irrigation Management\n- Water in the early morning or evening.\n- Don’t over-irrigate. Most crops need 1–2 inches of water per week.\n- Drip irrigation saves water and targets plant roots.\n\n4. Crop Rotation\n- Avoid planting the same crop in the same field repeatedly.\n- Rotate legumes, cereals, and root crops.\n- Improves soil fertility and reduces disease.\n\n5. Harvest Timing\n- Know the right maturity stage for harvesting.\n- Harvest too early = Low yield. Too late = Quality loss.\n- Store crops in clean, dry places.\n\n📌 Smart Practices:\n- Keep farm records: What you planted, when, and what was applied.\n- Train with extension officers and farmer groups.\n\n⚠️ Don't:\n- Ignore minor pests – they multiply fast!\n- Over-water crops.\n- Harvest without planning for storage.\n\n🌿 Wisdom:\n\"You don’t just grow crops, you manage life. A managed farm is a productive farm.\"";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agronomy);

        // Set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Agronomy Tips");
        }

        // Setup Read More logic
        setupReadMore();
    }

    private void setupReadMore() {
        TextView plantingText = findViewById(R.id.planting_guides_text);
        Button plantingReadMore = findViewById(R.id.planting_guides_read_more);
        TextView fertilizationText = findViewById(R.id.fertilization_text);
        Button fertilizationReadMore = findViewById(R.id.fertilization_read_more);
        TextView cropText = findViewById(R.id.crop_management_text);
        Button cropReadMore = findViewById(R.id.crop_management_read_more);

        plantingReadMore.setOnClickListener(v -> {
            plantingText.setText(PLANTING_GUIDES_FULL);
            plantingText.setMaxLines(Integer.MAX_VALUE);
            plantingReadMore.setVisibility(Button.GONE);
        });
        fertilizationReadMore.setOnClickListener(v -> {
            fertilizationText.setText(FERTILIZATION_FULL);
            fertilizationText.setMaxLines(Integer.MAX_VALUE);
            fertilizationReadMore.setVisibility(Button.GONE);
        });
        cropReadMore.setOnClickListener(v -> {
            cropText.setText(CROP_MANAGEMENT_FULL);
            cropText.setMaxLines(Integer.MAX_VALUE);
            cropReadMore.setVisibility(Button.GONE);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}