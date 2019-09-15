# The HTTP Client and WebSocket APIs
This chapter includes 20 problems that are meant to cover the HTTP Client and WebSocket APIs.

Do you remember `HttpUrlConnection`? Well, JDK 11 comes with the HTTP Client API as a reinvention of `HttpUrlConnection`. 
The HTTP Client API is easy to use and supports HTTP/2 (default) and HTTP/1.1. For backward compatibility, the HTTP Client API 
will automatically downgrade from HTTP/2 to HTTP 1.1 when the server doesn't support HTTP/2. Moreover, the HTTP Client API 
supports synchronous and asynchronous programming models and relies on streams to transfer data (reactive streams). It also 
supports the WebSocket protocol, which is used in real-time web applications to provide client-server communication with low 
message overhead.
