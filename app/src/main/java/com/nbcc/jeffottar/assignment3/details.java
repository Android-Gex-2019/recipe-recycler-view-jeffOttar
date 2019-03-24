/**
 * @file
 * @author Jeff Ottar-
 * @version 1.0
 *
 *
 * @section DESCRIPTION
 * < >
 *
 *
 * @section LICENSE
 *
 *
 * Copyright 2017
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package com.nbcc.jeffottar.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//using picasso for pictures
import com.squareup.picasso.Picasso;




public class details extends AppCompatActivity {

    /**
     * set up for the detail activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if(intent!=null) {//if there is a recipe intent
            Recipe recipe = (Recipe) intent.getSerializableExtra("recipe");//get the clicked recipe

            TextView name = findViewById(R.id.detail_name);//set up text views
            name.setText(recipe.name);
            TextView directions = findViewById(R.id.detail_directions);
            directions.setText(recipe.directions);
            TextView ingredients = findViewById(R.id.detail_ingredients);
            ingredients.setText(recipe.ingredients);

            ImageView image = findViewById(R.id.detail_image);//set up image
            Picasso.get()
                    .load(recipe.image)
                    .fit()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(image);

        }

//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.text_message);
//        textView.setText(message);
    }
}
