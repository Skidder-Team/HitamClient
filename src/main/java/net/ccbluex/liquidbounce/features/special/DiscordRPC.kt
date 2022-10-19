package net.ccbluex.liquidbounce.features.special;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.pipe.PipeStatus;
import java.time.OffsetDateTime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import net.ccbluex.liquidbounce.LiquidBounce;
import net.ccbluex.liquidbounce.utils.ServerUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(mv = {1, 6, 0}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\b\002\030\0002\0020\001B\007\b\002\006\002\020\002J\006\020\f\032\0020\rJ\006\020\016\032\0020\rJ\b\020\017\032\0020\rH\002R\016\020\003\032\0020\004X\016\006\002\n\000R\016\020\005\032\0020\006X\004\006\002\n\000R\016\020\007\032\0020\bX\016\006\002\n\000R\026\020\t\032\n \013*\004\030\0010\n0\nX\004\006\002\n\000\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/special/DiscordRPC;", "", "()V", "fdpwebsite", "", "ipcClient", "Lcom/jagrosh/discordipc/IPCClient;", "running", "", "timestamp", "Ljava/time/OffsetDateTime;", "kotlin.jvm.PlatformType", "run", "", "stop", "update", "HitamClient"})
public final class DiscordRPC {
  @NotNull
  public static final DiscordRPC INSTANCE = new DiscordRPC();
  
  @NotNull
  private static final IPCClient ipcClient = new IPCClient(968786352739082280L);
  
  private static final OffsetDateTime timestamp = OffsetDateTime.now();
  
  private static boolean running;
  
  @NotNull
  private static String fdpwebsite = "hitam.nig - ";
  
  public final void run() {
    ipcClient.setListener(new DiscordRPC$run$1());
    ipcClient.connect(new com.jagrosh.discordipc.entities.DiscordBuild[0]);
  }
  
  @Metadata(mv = {1, 6, 0}, k = 1, xi = 48, d1 = {"\000\037\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002*\001\000\b\n\030\0002\0020\001J\034\020\002\032\0020\0032\b\020\004\032\004\030\0010\0052\b\020\006\032\004\030\0010\007H\026J\022\020\b\032\0020\0032\b\020\004\032\004\030\0010\005H\026\006\t"}, d2 = {"net/ccbluex/liquidbounce/features/special/DiscordRPC$run$1", "Lcom/jagrosh/discordipc/IPCListener;", "onClose", "", "client", "Lcom/jagrosh/discordipc/IPCClient;", "json", "Lorg/json/JSONObject;", "onReady", "HitamClient"})
  public static final class DiscordRPC$run$1 implements IPCListener {
    public void onReady(@Nullable IPCClient client) {
      DiscordRPC.running = true;
      ThreadsKt.thread$default(false, false, null, null, 0, DiscordRPC$run$1$onReady$1.INSTANCE, 31, null);
    }
    
    @Metadata(mv = {1, 6, 0}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
    static final class DiscordRPC$run$1$onReady$1 extends Lambda implements Function0<Unit> {
      public static final DiscordRPC$run$1$onReady$1 INSTANCE = new DiscordRPC$run$1$onReady$1();
      
      public final void invoke() {
        while (DiscordRPC.running) {
          DiscordRPC.INSTANCE.update();
          try {
            Thread.sleep(1000L);
          } catch (InterruptedException interruptedException) {}
        } 
      }
      
      DiscordRPC$run$1$onReady$1() {
        super(0);
      }
    }
    
    public void onClose(@Nullable IPCClient client, @Nullable JSONObject json) {
      DiscordRPC.running = false;
    }
  }
  
  private final void update() {
    RichPresence.Builder builder = new RichPresence.Builder();
    builder.setStartTimestamp(timestamp);
    builder.setLargeImage("epep", Intrinsics.stringPlus("Hitam Client", LiquidBounce.CLIENT_VERSION));
    builder.setSmallImage("necro", "Necro's shitcode edition");
    builder.setDetails("Playing Hitam Client 1.8.9");
    String str1 = ServerUtils.getRemoteIp(), it = str1;
    int $i$a$-also-DiscordRPC$update$1 = 0;
    builder.setState(StringsKt.equals(it, "idling", true) ? "Currently in main menu" : ("Playing on " + it + ' '));
    if (ipcClient.getStatus() == PipeStatus.CONNECTED)
      ipcClient.sendRichPresence(builder.build()); 
  }
  
  public final void stop() {
    ipcClient.close();
  }
}
