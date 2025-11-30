package com.yugesh.multithreading_cuncurrency.completableFuture.example_1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class CompletableFutureGuide {

    // ============ 1. CREATION METHODS ============

    // Create an already completed future
    public static void creatingCompletedFuture() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("Done");
        System.out.println(cf.join()); // Output: Done
    }

    // Create an empty future that will be completed later
    public static void creatingEmptyFuture() {
        CompletableFuture<String> cf = new CompletableFuture<>();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            cf.complete("Task completed!"); // Manually complete it
        }).start();

        System.out.println(cf.join()); // Output: Task completed!
    }

    // Create future from a supplier (async computation)
    public static void supplyAsync() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
            return "Result from async task";
        });

        System.out.println(cf.join()); // Wait and get result
    }

    // Create future for a task that doesn't return value
    public static void runAsync() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("Task running asynchronously");
        });

        cf.join(); // Wait for completion
    }

    // ============ 2. TRANSFORMATION METHODS ============

    // Transform the result using thenApply
    public static void thenApplyExample() {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 5)
                .thenApply(x -> {
                    System.out.println("Multiplying " + x + " by 2");
                    return x * 2;
                })
                .thenApply(x -> {
                    System.out.println("Adding 10 to " + x);
                    return x + 10;
                });

        System.out.println("Final result: " + cf.join()); // Output: 20
    }

    // thenApplyAsync - apply in separate thread
    public static void thenApplyAsyncExample() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(s -> {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    return s + " World";
                });

        System.out.println(cf.join()); // Output: Hello World
    }

    // ============ 3. CONSUMPTION METHODS ============

    // Accept result without returning (side effects)
    public static void thenAcceptExample() {
        CompletableFuture.supplyAsync(() -> "Data processed")
                .thenAccept(result -> {
                    System.out.println("Consumer received: " + result);
                })
                .join();
    }

    // thenAcceptAsync - accept in separate thread
    public static void thenAcceptAsyncExample() {
        CompletableFuture.supplyAsync(() -> "Processing done")
                .thenAcceptAsync(result -> {
                    System.out.println("Async consumer: " + result);
                })
                .join();
    }

    // Run action after completion (ignoring result)
    public static void thenRunExample() {
        CompletableFuture.supplyAsync(() -> "Some data")
                .thenRun(() -> System.out.println("Task completed, doing cleanup"))
                .join();
    }

    // ============ 4. COMBINING FUTURES ============

    // Combine two futures with thenCombine
    public static void thenCombineExample() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 3);

        CompletableFuture<Integer> result = cf1.thenCombine(cf2, (a, b) -> {
            System.out.println("Combining " + a + " and " + b);
            return a + b;
        });

        System.out.println("Sum: " + result.join()); // Output: 8
    }

    // Compose futures with thenCompose (flatMap)
    public static void thenComposeExample() {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(x -> {
                    // Return a CompletableFuture, not just a value
                    return CompletableFuture.supplyAsync(() -> x * 2);
                });

        System.out.println("Result: " + cf.join()); // Output: 10
    }

    // Accept both futures with thenAcceptBoth
    public static void thenAcceptBothExample() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "World");

        cf1.thenAcceptBoth(cf2, (a, b) -> {
            System.out.println(a + " " + b); // Output: Hello World
        }).join();
    }

    // ============ 5. HANDLING MULTIPLE FUTURES ============

    // Wait for all futures to complete
    public static void allOfExample() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Task 1 done");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Task 2 done");
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> "Task 3 done");

        CompletableFuture.allOf(cf1, cf2, cf3)
                .thenRun(() -> System.out.println("All tasks completed"))
                .join();
    }

    // Wait for any future to complete
    public static void anyOfExample() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return "Slow task";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Fast task");

        Object result = CompletableFuture.anyOf(cf1, cf2).join();
        System.out.println("First to complete: " + result); // Output: Fast task
    }

    // ============ 6. EXCEPTION HANDLING ============

    // Handle exceptions with exceptionally
    public static void exceptionallyExample() {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return 5;
        }).exceptionally(ex -> {
            System.out.println("Error caught: " + ex.getMessage());
            return -1; // Default value
        });

        System.out.println("Result: " + cf.join()); // Output: -1
    }

    // Handle both success and exception with whenComplete
    public static void whenCompleteExample() {
        CompletableFuture.supplyAsync(() -> 10)
                .thenApply(x -> x / 0) // This will throw exception
                .whenComplete((result, exception) -> {
                    if (exception != null) {
                        System.out.println("Exception occurred: " + exception.getClass().getSimpleName());
                    } else {
                        System.out.println("Result: " + result);
                    }
                })
                .join();
    }

    // Handle with more control using handle
    public static void handleExample() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Error in processing");
        }).handle((result, exception) -> {
            if (exception != null) {
                return "Handled error: " + exception.getMessage();
            }
            return "Success: " + result;
        });

        System.out.println(cf.join());
    }

    // ============ 7. OTHER USEFUL METHODS ============

    // Complete manually
    public static void completeExample() {
        CompletableFuture<String> cf = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            cf.complete("Manually completed");
        }).start();

        System.out.println(cf.join());
    }

    // Complete exceptionally
    public static void completeExceptionallyExample() {
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.completeExceptionally(new RuntimeException("Error from outside"));

        try {
            cf.join();
        } catch (CompletionException e) {
            System.out.println("Caught: " + e.getCause().getMessage());
        }
    }

    // Check if already completed
    public static void isDoneExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("Done");
        System.out.println("Is done: " + cf.isDone()); // Output: true
    }

    // ============ PRACTICAL REAL-WORLD EXAMPLE ============

    public static void realWorldExample() {
        System.out.println("=== Real-World Example ===");
        long start = System.currentTimeMillis();

        CompletableFuture<String> result = APIService.fetchUserData(1)
                .thenCompose(userData -> APIService.fetchUserPosts(userData))
                .thenCompose(postsData -> APIService.fetchComments(postsData))
                .thenApply(comments -> "Final result: " + comments)
                .exceptionally(ex -> "Error occurred: " + ex.getMessage());

        System.out.println(result.join());
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
    }

    static void main() {
        System.out.println("1. Creating Completed Future:");
        creatingCompletedFuture();

        System.out.println("\n2. Supply Async:");
        supplyAsync();

        System.out.println("\n3. Then Apply (Chain transformations):");
        thenApplyExample();

        System.out.println("\n4. Then Accept (Side effects):");
        thenAcceptExample();

        System.out.println("\n5. Then Combine (Merge two futures):");
        thenCombineExample();

        System.out.println("\n6. Then Compose (Flatten nested futures):");
        thenComposeExample();

        System.out.println("\n7. All Of (Wait for all):");
        allOfExample();

        System.out.println("\n8. Any Of (Wait for any):");
        anyOfExample();

        System.out.println("\n9. Exception Handling:");
        exceptionallyExample();

        System.out.println("\n10. When Complete:");
        whenCompleteExample();

        System.out.println("\n11. Real-World Example:");
        realWorldExample();
    }

    // Simulate API calls
    static class APIService {
        static CompletableFuture<String> fetchUserData(int userId) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                return "User#" + userId;
            });
        }

        static CompletableFuture<String> fetchUserPosts(String userData) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                return userData + " Posts";
            });
        }

        static CompletableFuture<String> fetchComments(String postsData) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                return postsData + " Comments";
            });
        }
    }
}