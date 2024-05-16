function makeListItem(prefix, icon, primaryText, secondaryText, suffix, id) {
    out =
        "<div class=\"listItem\" onclick=\"onListItemClick(" + id + ")\">"
            + "<div class=\"prefix\">"
            + prefix
            + "</div>"
            + "<div class=\"icon\">"
            + icon
            + "</div>"
            + "<div class=\"text\">"
               + "<div class=\"primaryText\">"
               + primaryText
               + "</div>"
               + "<div class=\"secondaryText\">"
               + secondaryText
               + "</div>"
            + "</div>"
            + "<div class=\"suffix\">"
            + suffix
            + "</div>"
        + "</div>";
    return out;
}