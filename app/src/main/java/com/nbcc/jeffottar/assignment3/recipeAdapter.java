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

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;


public class recipeAdapter extends
        RecyclerView.Adapter<recipeAdapter.RecipeViewHolder>  {

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView nameItemView;
        public final TextView descItemView;
        final recipeAdapter mAdapter;

        public RecipeViewHolder(View itemView, recipeAdapter adapter) {
            super(itemView);
            nameItemView = itemView.findViewById(R.id.name);
            descItemView = itemView.findViewById(R.id.desc);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
//            int mPosition = getLayoutPosition();
//            String element = recipeList.get(mPosition);
//            recipeList.set(mPosition, "Clicked! " + element);
//            mAdapter.notifyDataSetChanged();

            //get the recipe clicked and set up the new activity with that recipe
            Recipe recipe = recipeList.get(getLayoutPosition());
            //Intent intent = new Intent(this, details.class);
            Intent intent = new Intent(context, details.class);//context of what called this rather than "this" needed

            intent.putExtra("recipe",recipe);

            context.startActivity(intent);
        }
    }

    private final LinkedList<Recipe> recipeList;
    private LayoutInflater mInflater;
    private Context context;//context needed for intent

    public recipeAdapter(Context context,
                           LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
        this.context = context;
    }

    @NonNull
    @Override
    public recipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipe_item,
                viewGroup, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull recipeAdapter.RecipeViewHolder RecipeViewHolder, int i) {
        Recipe mCurrent = recipeList.get(i);
        RecipeViewHolder.nameItemView.setText(mCurrent.name);
        RecipeViewHolder.descItemView.setText(mCurrent.description);
        //RecipeViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}