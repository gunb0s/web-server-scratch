use std::thread;

pub struct ThreadPool {
    workers: Vec<Worker>,
}

impl ThreadPool {
    /// 새 스레드풀 생성
    ///
    /// size 는 풀 안의 스레드 개수입니다.
    ///
    /// # Panics
    ///
    /// `new` 함수는 size 가 0일때 패닉을 일으킵니다
    pub fn new(size: usize) -> ThreadPool {
        assert!(size > 0);

        let mut workers = Vec::with_capacity(size);

        for id in 0..size {
            // 스레드들을 생성하고 벡터 내에 보관합니다
            workers.push(Worker::new(id));
        }

        ThreadPool {
            workers
        }
    }

    pub fn execute<F>(&self, f: F)
        where
            F: FnOnce() + Send + 'static
    {}
}

struct Worker {
    id: usize,
    thread: thread::JoinHandle<()>,
}

impl Worker {
    fn new(id: usize) -> Worker {
        let thread = thread::spawn(|| {});

        Worker {
            id,
            thread
        }
    }
}
