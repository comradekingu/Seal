package com.junkfood.seal.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junkfood.seal.ui.theme.applyOpacity


@Composable
fun PreferenceItem(
    title: String,
    description: String? = null,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Surface(
        modifier = if (enabled) Modifier.clickable { onClick() } else Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 16.dp)
                        .size(24.dp),
                    tint = with(MaterialTheme.colorScheme.secondary) {
                        if (enabled) this else copy(alpha = 0.68f)
                    }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = if (icon == null) 12.dp else 0.dp)
            ) {
                with(MaterialTheme) {

                    Text(
                        text = title,
                        maxLines = 1,
                        style = typography.titleLarge.copy(fontSize = 20.sp),
                        color = colorScheme.onSurface.applyOpacity(enabled)
                    )
                    if (description != null)
                        Text(
                            text = description,
                            color = colorScheme.onSurfaceVariant.applyOpacity(enabled),
                            maxLines = 2, overflow = TextOverflow.Ellipsis,
                            style = typography.bodyMedium,
                        )
                }
            }
        }
    }

}

@Composable
fun PreferenceSwitch(
    title: String,
    description: String? = null,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    isChecked: Boolean,
    checkedIcon: ImageVector? = Icons.Outlined.Check,
    onClick: (() -> Unit),
) {
    Surface(
        modifier = if (enabled) Modifier.clickable { onClick() } else Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 16.dp)
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.secondary.applyOpacity(enabled)
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
                    color = if (enabled) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.62f
                    ), overflow = TextOverflow.Ellipsis
                )
                if (!description.isNullOrEmpty())
                    Text(
                        text = description,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.applyOpacity(enabled),
                        maxLines = 2,
                        style = MaterialTheme.typography.bodyMedium,
                    )
            }
            Switch(
                checked = isChecked,
                onCheckedChange = null,
                modifier = Modifier.padding(start = 20.dp, end = 6.dp),
                enabled = enabled
            )
        }
    }
}

@Composable
fun PreferencesCaution(
    title: String,
    description: String? = null,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(MaterialTheme.colorScheme.errorContainer)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .padding(start = 8.dp, end = 16.dp)
                    .size(24.dp),
                tint = with(MaterialTheme.colorScheme.error) {
                    if (enabled) this else copy(alpha = 0.68f)
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = if (icon == null) 12.dp else 0.dp, end = 12.dp)
        ) {
            with(MaterialTheme) {

                Text(
                    text = title,
                    maxLines = 1,
                    style = typography.titleLarge.copy(fontSize = 20.sp),
                    color = colorScheme.onErrorContainer.applyOpacity(enabled)
                )
                if (description != null)
                    Text(
                        text = description,
                        color = colorScheme.onErrorContainer.applyOpacity(enabled),
                        maxLines = 2, overflow = TextOverflow.Ellipsis,
                        style = typography.bodyMedium,
                    )
            }
        }
    }


}

@Composable
fun PreferencesHint(
    title: String,
    description: String? = null,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .padding(start = 8.dp, end = 16.dp)
                    .size(24.dp),
                tint = with(MaterialTheme.colorScheme.secondary) {
                    if (enabled) this else copy(alpha = 0.68f)
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = if (icon == null) 12.dp else 0.dp, end = 12.dp)
        ) {
            with(MaterialTheme) {

                Text(
                    text = title,
                    maxLines = 1,
                    style = typography.titleLarge.copy(fontSize = 20.sp),
                    color = colorScheme.onSecondaryContainer.applyOpacity(enabled)
                )
                if (description != null)
                    Text(
                        text = description,
                        color = colorScheme.onSecondaryContainer.applyOpacity(enabled),
                        maxLines = 2, overflow = TextOverflow.Ellipsis,
                        style = typography.bodyMedium,
                    )
            }
        }
    }
}

@Composable
fun CreditItem(
    title: String,
    license: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Surface(
        modifier = if (enabled) Modifier.clickable { onClick() } else Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                with(MaterialTheme) {
                    Text(
                        text = title,
                        maxLines = 1,
                        style = typography.titleMedium,
                        color = colorScheme.onSurface.applyOpacity(enabled)
                    )
                    Text(
                        text = license.toString(),
                        color = colorScheme.onSurfaceVariant.applyOpacity(enabled),
                        maxLines = 2, overflow = TextOverflow.Ellipsis,
                        style = typography.bodyMedium,
                    )
                }
            }
        }
    }

}

@Composable
fun Subtitle(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 28.dp, bottom = 12.dp),
        color = color,
        style = MaterialTheme.typography.labelLarge
    )
}

