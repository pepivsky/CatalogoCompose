package com.example.catalogocompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.rounded.FamilyRestroom
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catalogocompose.R

@Preview(showBackground = true)
@Composable
fun PlayerMainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OptionsMenu()
        AlbumImage()
        TrackInfo()
        PlayingControls()
    }
}

@Composable
fun OptionsMenu() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(imageVector = Icons.Outlined.ExpandMore, contentDescription = "Expand more")
        Spacer(modifier = Modifier.weight(1F))
        Icon(imageVector = Icons.Outlined.MoreVert, contentDescription = "More options")
    }
}

@Composable
fun AlbumImage() {
    Image(
        painter = painterResource(id = R.drawable.album_image),
        contentDescription = "Album image",
        modifier = Modifier.clip(RoundedCornerShape(20.dp))
    )
}

@Composable
fun TrackInfo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Cyan)
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopStart),
            text = "The adults are talking",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(modifier = Modifier.align(Alignment.BottomStart), text = "The Strokes")
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Like Track"
        )
    }
}

@Composable
fun PlayingControls() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), progress = 0.6F)
        Spacer(modifier = Modifier.size(2.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1F))
            Text(modifier = Modifier,text = "2:09 / 3:59")
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier.size(50.dp),shape = CircleShape, contentPadding = PaddingValues(0.dp),onClick = { /*TODO*/ }) {
                Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Rounded.SkipPrevious, contentDescription = "Previous track")
            }
            Button(modifier = Modifier.clip(RoundedCornerShape(40)).height(50.dp).width(80.dp),onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Pause, contentDescription = "Pause track")
            }
            Button(modifier = Modifier.size(50.dp),shape = CircleShape, contentPadding = PaddingValues(0.dp),onClick = { /*TODO*/ }) {
                Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Rounded.SkipNext, contentDescription = "Previous track")
            }

        }

    }
}