/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Bird

object BirdRepository {

    val birds = listOf(
        Bird(
            birdId = 1, pictureResId = R.drawable.hen, name = "Ace Hentura", species = "Hen",
            gender = "Male"
        ),
        Bird(
            birdId = 2, pictureResId = R.drawable.american_pekin, name = "Baquack Obama",
            species = "Pekin Duck", gender = "Male"
        ),
        Bird(
            birdId = 3, pictureResId = R.drawable.parakeet, name = "Chandler Wing",
            species = "Parakeet", gender = "Male"
        ),
        Bird(
            birdId = 4, pictureResId = R.drawable.wood_duck, name = "Duck Vader",
            species = "Wood Duck", gender = "Female"
        ),
        Bird(
            birdId = 5, pictureResId = R.drawable.pigeon, name = "Kanye Nest", species = "Pigeon",
            gender = "Male"
        ),
        Bird(
            birdId = 6, pictureResId = R.drawable.mallard, name = "Mark Duckerberg",
            species = "Mallard Duck", gender = "Female"
        ),
        Bird(
            birdId = 7, pictureResId = R.drawable.parrot, name = "Parrot Hilton",
            species = "Parrot", gender = "Female"
        ),
        Bird(
            birdId = 8, pictureResId = R.drawable.mulga_parrot, name = "Robird DeNiro",
            species = "Mulga Parrot", gender = "Male"
        ),
        Bird(
            birdId = 9, pictureResId = R.drawable.seagull, name = "Steven Seagull",
            species = "Seagull", gender = "Male"
        ),
    )
}
