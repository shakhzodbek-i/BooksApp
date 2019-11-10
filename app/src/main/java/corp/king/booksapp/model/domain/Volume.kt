package corp.king.booksapp.model.domain

data class Volume(var kind: String,
                  var id: String,
                  var etag: String,
                  var selfLink: String,
                  var volumeInfo: VolumeInfo,
                  var userInfo: UserInfo) {

    data class VolumeInfo(var title: String,
                          var subtitle: String,
                          var authors: List<String>,
                          var publisher: String,
                          var publishedDate: String,
                          var description: String,
                          var pageCount: Int,
                          var mainCategory: String,
                          var categories: List<String>,
                          var averageRating: Double,
                          var ratingCount: Int,
                          var imageLinks: ImageLinks,
                          var language: String,
                          var previewLink: String,
                          var infoLink: String,
                          var canonicalVolumeLink: String)

    data class ImageLinks(var smallThumbnail: String,
                          var thumbnail: String,
                          var small: String,
                          var medium: String,
                          var large: String,
                          var extraLarge: String)

    data class UserInfo(var readingPosition: String)

}
