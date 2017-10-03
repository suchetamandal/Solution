public class EncodeDecodeTinyURL {
    Map<String,String> urlMap = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(longUrl.hashCode());
        urlMap.put(key,longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl.replace("http://tinyurl.com/",""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
